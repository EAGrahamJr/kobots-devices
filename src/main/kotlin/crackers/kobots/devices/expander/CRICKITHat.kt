/*
 * Copyright 2022-2023 by E. A. Graham, Jr.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package crackers.kobots.devices.expander

import com.diozero.api.*
import com.diozero.devices.motor.PwmMotor
import com.diozero.devices.sandpit.motor.BasicStepperController
import com.diozero.devices.sandpit.motor.BasicStepperController.*
import crackers.kobots.devices.expander.CRICKITHatSeesaw.Companion.MOTOR1A
import crackers.kobots.devices.expander.CRICKITHatSeesaw.Companion.MOTOR1B
import crackers.kobots.devices.expander.CRICKITHatSeesaw.Companion.MOTOR2A
import crackers.kobots.devices.expander.CRICKITHatSeesaw.Companion.MOTOR2B
import crackers.kobots.devices.expander.CRICKITHatSeesaw.Companion.NEOPIXEL_PIN
import crackers.kobots.devices.expander.CRICKITHatSeesaw.Companion.STATUS_NEOPIXEL_PIN
import crackers.kobots.devices.expander.CRICKITHatSeesaw.Companion.defaultI2CDevice
import crackers.kobots.devices.expander.Types.*
import crackers.kobots.devices.lighting.NeoPixel
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw

internal enum class Types(internal val offset: Int) {
    SIGNAL(100), TOUCH(110), SERVO(120), MOTOR(130), DRIVE(140), NEOPIXEL(150), SPEAKER(160);

    fun deviceNumber(device: Int) = offset + device
    fun indexOf(deviceId: Int) = deviceId - offset
}

/**
 * A device factory for the AdaFruit
 * [CRICKIT](https://learn.adafruit.com/adafruit-crickit-hat-for-raspberry-pi-linux-computers?view=all).
 *
 * It is **HIGHLY** recommended to use the convenience functions instead of creating devices via the builders or
 * constructors as the pin numbering gets a little odd.
 */
class CRICKITHat(val seeSaw: AdafruitSeeSaw = CRICKITHatSeesaw()) : DeviceInterface {

    @JvmOverloads
    constructor(i2CDevice: I2CDevice = defaultI2CDevice, initReset: Boolean = true) :
            this(CRICKITHatSeesaw(i2CDevice, initReset))

    private lateinit var neoPixelPort: NeoPixel

    private val statusPixel by lazy { NeoPixel(seeSaw, 1, STATUS_NEOPIXEL_PIN, 3) }

    private val deviceFactory by lazy { CRICKITHatDeviceFactory(seeSaw) }

    /**
     * Convenience function to get a digital input on the Signal port [pin] (1-8), with optional [pullDown]
     */
    fun signalDigitalIn(pin: Int, pullDown: Boolean = false) =
        DigitalInputDevice(
            deviceFactory,
            SIGNAL.deviceNumber(pin),
            if (pullDown) GpioPullUpDown.PULL_DOWN else GpioPullUpDown.PULL_UP,
            GpioEventTrigger.NONE
        )

    /**
     * Convenience function to get a digital output on the Signal port [pin] (1-8)
     */
    fun signalDigitalOut(pin: Int) = DigitalOutputDevice(deviceFactory, SIGNAL.deviceNumber(pin), true, false)

    /**
     * Convenience function to get an analog input on the  Signal port [pin] (1-8)
     */
    fun signalAnalogIn(pin: Int) = AnalogInputDevice(deviceFactory, SIGNAL.deviceNumber(pin))

    /**
     * Convenience function to get a digital input on one of the touchpads.
     */
    fun touchDigitalIn(pin: Int) = DigitalInputDevice(deviceFactory, TOUCH.deviceNumber(pin))

    /**
     * Convenience function to get an analog input on one of the touchpads.
     */
    fun touchAnalogIn(pin: Int) = AnalogInputDevice(deviceFactory, TOUCH.deviceNumber(pin))

    /**
     * Convenience function to get a servo device on the Servo ports [pin] (1-4)
     */
    fun servo(pin: Int, servoTrim: ServoTrim = ServoTrim.DEFAULT): ServoDevice =
        ServoDevice.Builder.builder(SERVO.deviceNumber(pin))
            .setDeviceFactory(deviceFactory)
            .setTrim(servoTrim)
            .build()

    /**
     * Convenience function to use the Motor ports for bidirectional motors, where [index] is the motor _number_ (1 or
     * 2). Note this is 5v.
     */
    fun motor(index: Int): PwmMotor {
        val pins = if (index == 1) MOTOR1A to MOTOR1B else MOTOR2A to MOTOR2B
        return PwmMotor(deviceFactory, pins.first, pins.second)
    }

    /**
     * Convenience function to get PWM-able outputs.  Note this is 5v.
     */
    fun drive(index: Int): PwmOutputDevice = PwmOutputDevice(deviceFactory, DRIVE.deviceNumber(index), 1000, 0f)

    /**
     * Get **the** unipolar stepper controller from the `DRIVE` ports. Note this is 5v.
     */
    fun unipolarStepperPort(): BasicStepperController {
        // create the pins - these are in the order to pass to the controller
        val pins = stepperPins(DRIVE).toTypedArray()
        return UnipolarBasicController(pins)
    }

    /**
     * Get a controller from the motor ports. Note this is 5v.
     */
    fun motorStepperPort(): BasicStepperController {
        val pins = stepperPins(MOTOR)

        val terminalA = BiPolarTerminal(pins[0], pins[1])
        val terminalB = BiPolarTerminal(pins[2], pins[3])

        return BipolarBasicController(terminalA, terminalB)
    }

    /**
     * Four pins, get the ports.
     */
    private fun stepperPins(type: Types) = (1..4)
        .map { deviceFactory.boardInfo.getByPwmOrGpioNumber(type.deviceNumber(it)).get() }
        .map { deviceFactory.getInternalPwm(it, deviceFactory.createPwmPinKey(it)) }
        .map { PwmStepperPin(it) }

    /**
     * Convenience function to use the [NeoPixel] port. Note that this is **not** a `diozero` WS2811 but an
     * implementation from this library.
     */
    fun neoPixel(numPixels: Int, bitsPerPixel: Int = 3): NeoPixel =
        if (::neoPixelPort.isInitialized) {
            neoPixelPort
        } else {
            NeoPixel(seeSaw, numPixels, NEOPIXEL_PIN, bitsPerPixel).also { neoPixelPort = it }
        }

    /**
     * Convenience function to access the on-board status [NeoPixel]. Note that this is **not** a `diozero` WS2811 but
     * an implementation from this library.
     */
    fun statusPixel() = statusPixel

    // -----------------------------------------------------------------------------------------------------------------
    // diozero device and factory stuff

    override fun close() {
        try {
            deviceFactory.close()
            seeSaw.close()
        } catch (_: Throwable) {
        }
    }
}
