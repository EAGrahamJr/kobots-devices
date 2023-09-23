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
import com.diozero.internal.PwmServoDevice
import com.diozero.internal.spi.*
import com.diozero.sbc.BoardPinInfo
import crackers.kobots.devices.microcontroller.*
import javax.naming.OperationNotSupportedException

/**
 * A factory for the CRICKIT Hat: provides the `diozero` devices exposed via the CRICKIT Hat. Not to be used externally.
 */
internal class CRICKITHatDeviceFactory(private val seeSaw: AdafruitSeeSaw) :
    AbstractDeviceFactory(NAME),
    GpioDeviceFactoryInterface,
    AnalogInputDeviceFactoryInterface,
    ServoDeviceFactoryInterface,
    PwmOutputDeviceFactoryInterface {

    override fun getName() = NAME

    // -----------------------------------------------------------------------------------------------------------------
    // internal quick-access functionality
    /**
     * Get a device for the indicated touchpad (1-4)
     */
    internal fun touch(index: Int) = SeesawCapacitivePort(seeSaw, index)

    /**
     * Get a device for the indicated signal (1-8)
     */
    internal fun signal(index: Int) = SeesawDigitalPort(seeSaw, CRICKITHatSeesaw.DIGITAL_PINS[index - 1])

    /**
     * Create the `diozero` "board info" for this expander.
     *
     * - `header`: the "bus" the device is tied to
     * - `pin`: the Crickit offset as defined in the companion
     * - `deviceId`: the "type" offset (10, 20) plus the device number (1,2,3)
     *   - this is to distinguish creating conflicting devices (e.g. Touch and Signal both have digital inputs)
     * - `name`: header plus (device id - offset)
     */
    internal val boardInfo: BoardPinInfo = BoardPinInfo().apply {
        val gpioPinModes = setOf(DeviceMode.DIGITAL_INPUT, DeviceMode.DIGITAL_OUTPUT, DeviceMode.ANALOG_INPUT)
        CRICKITHatSeesaw.DIGITAL_PINS.forEachIndexed { index, pin ->
            val info = crickitPinInfo(Types.SIGNAL, index + 1, pin, gpioPinModes, CRICKITHatSeesaw.ANALOG_MAX)
            addAdcPinInfo(info)
            addGpioPinInfo(info)
        }

        val touchPinModes = setOf(DeviceMode.ANALOG_INPUT, DeviceMode.DIGITAL_INPUT)
        CRICKITHatSeesaw.TOUCH_PAD_PINS.forEachIndexed { index, pin ->
            val info = crickitPinInfo(Types.TOUCH, index + 1, pin, touchPinModes, CRICKITHatSeesaw.ANALOG_MAX)
            addAdcPinInfo(info)
            addGpioPinInfo(info)
        }

        val servoMode = setOf(DeviceMode.SERVO, DeviceMode.PWM_OUTPUT)
        CRICKITHatSeesaw.SERVOS.forEachIndexed { index, pin ->
            val info = crickitPinInfo(Types.SERVO, index + 1, pin, servoMode)
            addGpioPinInfo(info)
        }

        // all the motor pins
        val pwmMode = setOf(DeviceMode.PWM_OUTPUT)
        CRICKITHatSeesaw.MOTORS.forEachIndexed { index, pin ->
            crickitPinInfo(Types.MOTOR, index + 1, pin, pwmMode).apply {
                addPwmPinInfo(header, deviceNumber, name, physicalPin, Types.MOTOR.ordinal, physicalPin, pwmMode)
            }
        }

        // stepper pins
        CRICKITHatSeesaw.DRIVES.forEachIndexed { index, pin ->
            crickitPinInfo(Types.DRIVE, index + 1, pin, pwmMode).apply {
                addPwmPinInfo(header, deviceNumber, name, physicalPin, Types.DRIVE.ordinal, physicalPin, pwmMode)
            }
        }
    }

    /**
     * Create the pins for this CRICKIT
     */
    private fun crickitPinInfo(
        type: Types,
        deviceId: Int,
        pin: Int,
        pinModes: Collection<DeviceMode>,
        vRef: Float = -1f
    ) = PinInfo(type.name, name, type.deviceNumber(deviceId), pin, "$type-$deviceId", pinModes, vRef)

    override fun getBoardPinInfo() = boardInfo

    override fun createDigitalInputDevice(
        key: String,
        pinInfo: PinInfo,
        pud: GpioPullUpDown,
        trigger: GpioEventTrigger
    ): GpioDigitalInputDeviceInterface = pinInfo.deviceNumber.let { deviceNum ->
        when (pinInfo.keyPrefix) {
            Types.SIGNAL.name -> {
                val signal = signal(Types.SIGNAL.indexOf(deviceNum)).apply {
                    mode = when (pud) {
                        GpioPullUpDown.NONE -> AdafruitSeeSaw.Companion.SignalMode.INPUT
                        GpioPullUpDown.PULL_UP -> AdafruitSeeSaw.Companion.SignalMode.INPUT_PULLUP
                        GpioPullUpDown.PULL_DOWN -> AdafruitSeeSaw.Companion.SignalMode.INPUT_PULLDOWN
                    }
                }
                SeesawDigitalDevice(key, this, deviceNum, signal)
            }

            Types.TOUCH.name -> {
                val sensor = touch(Types.TOUCH.indexOf(deviceNum))
                DigitalTouch(key, this, deviceNum, sensor)
            }

            else -> throw UnsupportedOperationException("Unknown device")
        }
    }

    override fun createDigitalOutputDevice(
        key: String,
        pinInfo: PinInfo,
        initialValue: Boolean
    ): GpioDigitalOutputDeviceInterface = pinInfo.deviceNumber.let { deviceNum ->
        if (pinInfo.keyPrefix == Types.SIGNAL.name) {
            val signal = signal(Types.SIGNAL.indexOf(deviceNum)).apply {
                mode = AdafruitSeeSaw.Companion.SignalMode.OUTPUT
            }
            SeesawDigitalDevice(key, this, deviceNum, signal)
        } else {
            throw UnsupportedOperationException("Unknown device")
        }
    }

    override fun createDigitalInputOutputDevice(
        key: String,
        pinInfo: PinInfo,
        mode: DeviceMode
    ): GpioDigitalInputOutputDeviceInterface {
        throw RuntimeIOException("Device must be either input or output (not both).")
    }

    override fun createAnalogInputDevice(key: String, pinInfo: PinInfo): AnalogInputDeviceInterface =
        pinInfo.deviceNumber.let { deviceNum ->
            when (pinInfo.keyPrefix) {
                Types.SIGNAL.name -> {
                    val signal = signal(Types.SIGNAL.indexOf(deviceNum)).apply {
                        mode = AdafruitSeeSaw.Companion.SignalMode.INPUT
                    }
                    SeesawAnalogInputDevice(key, this, deviceNum, signal)
                }

                Types.TOUCH.name -> {
                    val sensor = touch(Types.TOUCH.indexOf(deviceNum))
                    AnalogTouch(key, this, deviceNum, sensor)
                }

                else -> throw UnsupportedOperationException("Unknown device")
            }
        }

    // typical
    override fun getBoardServoFrequency() = 50
    override fun setBoardServoFrequency(servoFrequency: Int) {
        throw UnsupportedOperationException("Board does not support setting 'default' frequencies")
    }

    override fun createServoDevice(
        key: String,
        pinInfo: PinInfo,
        frequencyHz: Int,
        minPulseWidthUs: Int,
        maxPulseWidthUs: Int,
        initialPulseWidthUs: Int
    ): InternalServoDeviceInterface {
        val pwm = getInternalPwm(pinInfo, key, frequencyHz)
        return PwmServoDevice(key, this, pwm, minPulseWidthUs, maxPulseWidthUs, initialPulseWidthUs)
    }

    override fun getBoardPwmFrequency() = 50

    override fun setBoardPwmFrequency(pwmFrequency: Int) {
        throw OperationNotSupportedException("Cannot set board frequency")
    }

    override fun createPwmOutputDevice(
        key: String,
        pinInfo: PinInfo,
        pwmFrequency: Int,
        initialValue: Float
    ): InternalPwmOutputDeviceInterface = getInternalPwm(pinInfo, key, pwmFrequency).apply {
        value = initialValue
    }

    fun getInternalPwm(pinInfo: PinInfo, key: String, frequencyHz: Int? = null) = pinInfo.let {
        SeesawPWMDevice(key, it.deviceNumber, seeSaw, it.physicalPin, frequencyHz)
    }

    companion object {
        private const val NAME = "CRICKIT"
    }

    enum class Types(internal val offset: Int) {
        SIGNAL(100), TOUCH(110), SERVO(120), MOTOR(130), DRIVE(140), NEOPIXEL(150), SPEAKER(160);

        fun deviceNumber(device: Int) = offset + device
        fun indexOf(deviceId: Int) = deviceId - offset
    }
}
