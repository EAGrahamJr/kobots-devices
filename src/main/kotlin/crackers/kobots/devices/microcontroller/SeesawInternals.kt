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

package crackers.kobots.devices.microcontroller

import com.diozero.api.AnalogInputEvent
import com.diozero.api.DeviceMode
import com.diozero.api.DigitalInputEvent
import com.diozero.api.InvalidModeException
import com.diozero.internal.spi.*
import crackers.kobots.devices.expander.CRICKITHatSeesaw
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.truncate

/**
 * "Internal device" of the Crickit for the capacitive touch sensors.
 *
 * Because there's always a value present, the initial `read()` function will max the next 5 values and
 * assume any value greater than that (+100) is a "touch" for basic true/false functions.
 */
internal class SeesawCapacitivePort(private val seeSaw: AdafruitSeeSaw, padNumber: Int) {
    private val seesawPadIndex = padNumber - 1

    private val noTouchThreshold: Int by lazy {
        ((1..5).map { value }.max() + 100)
    }

    val value: Int
        get() = seeSaw.touchRead(seesawPadIndex)
    val isOn: Boolean
        get() = noTouchThreshold < value
}

// diozero bridge device
internal class DigitalTouch(
    key: String,
    factory: DeviceFactoryInterface,
    private val gpio: Int,
    private val sensor: SeesawCapacitivePort
) :
    AbstractInputDevice<DigitalInputEvent>(key, factory), GpioDigitalInputDeviceInterface {

    override fun getGpio() = gpio

    override fun setDebounceTimeMillis(debounceTime: Int) {
        throw UnsupportedOperationException("Not applicable")
    }

    override fun getValue() = sensor.isOn
}

// diozero bridge device
internal class AnalogTouch(
    key: String,
    factory: DeviceFactoryInterface,
    private val adc: Int,
    private val sensor: SeesawCapacitivePort
) : AbstractInputDevice<AnalogInputEvent>(key, factory), AnalogInputDeviceInterface {

    override fun getAdcNumber() = adc
    override fun getValue() = sensor.value / CRICKITHatSeesaw.ANALOG_MAX
    override fun generatesEvents() = false
}

/**
 * "Internal device" of the Crickit for the signal block. Note that changing modes of the device is allowed (although
 * not necessarily used in practice).
 */
internal class SeesawDigitalPort(private val seeSaw: AdafruitSeeSaw, private val seeSawPin: Int) {

    internal val canWrite = AtomicBoolean(false)

    // pull up vs pull down - pull-up needs to flip the value around for it to be consistent
    private val flipValue = AtomicBoolean(false)

    private lateinit var myMode: AdafruitSeeSaw.Companion.SignalMode
    var mode: AdafruitSeeSaw.Companion.SignalMode
        get() = myMode
        set(value) {
            myMode = value
            flipValue.set(mode != AdafruitSeeSaw.Companion.SignalMode.INPUT_PULLDOWN)
            canWrite.set(mode == AdafruitSeeSaw.Companion.SignalMode.OUTPUT)
            seeSaw.pinMode(seeSawPin, value)
        }

    var value: Boolean
        get() {
            if (canWrite.get()) throw InvalidModeException("Input is not allowed on output devices.")
            return seeSaw.digitalRead(seeSawPin).let { read -> if (flipValue.get()) !read else read }
        }
        set(value) {
            if (!canWrite.get()) throw InvalidModeException("Output is not allowed on input devices.")
            seeSaw.digitalWrite(seeSawPin, value)
        }

    fun read(): Int = seeSaw.analogRead(seeSawPin.toByte())
}

/**
 * "Internal device" of the Seesaw for the signal block, digital (input/output) flavor.
 */
internal class SeesawDigitalDevice(
    key: String,
    factory: DeviceFactoryInterface,
    private val deviceNumber: Int,
    private val delegate: SeesawDigitalPort
) : AbstractInputDevice<DigitalInputEvent>(key, factory),
    GpioDigitalOutputDeviceInterface,
    GpioDigitalInputDeviceInterface {

    override fun getGpio() = deviceNumber
    override fun getMode() = if (delegate.canWrite.get()) DeviceMode.DIGITAL_OUTPUT else DeviceMode.DIGITAL_INPUT
    override fun getValue() = delegate.value
    override fun setValue(value: Boolean) {
        delegate.value = value
    }

    override fun setDebounceTimeMillis(debounceTime: Int) {
        throw UnsupportedOperationException("Not supported")
    }
}

/**
 * "Internal device" of the Seesaw for the signal block, analog flavor.
 */
internal class SeesawAnalogInputDevice(
    key: String,
    factory: DeviceFactoryInterface,
    private val deviceNumber: Int,
    private val delegate: SeesawDigitalPort
) : AbstractInputDevice<AnalogInputEvent>(key, factory),
    AnalogInputDeviceInterface {

    override fun getAdcNumber() = deviceNumber
    override fun getValue() = delegate.read() / CRICKITHatSeesaw.ANALOG_MAX
    override fun generatesEvents() = false
}

/**
 * Internal PWM class for the Servo/Motor/Stepper ports on the CRICKIT.
 */
internal class SeesawPWMDevice(
    private val key: String,
    private val pwmNumber: Int,
    private val seeSaw: AdafruitSeeSaw,
    private val seeSawPin: Int,
    frequency: Int? = null
) : InternalPwmOutputDeviceInterface {

    private var frequencyHz: Int = 50
    private var currentValue = 0f
    private var open = true
    private var child = false

    init {
        if (frequency != null) pwmFrequency = frequency
    }

    override fun close() {
        open = false
    }

    override fun getKey() = key

    override fun isOpen() = open

    override fun isChild() = child

    override fun setChild(child: Boolean) {
        this.child = child
    }

    override fun getGpio() = -1

    override fun getPwmNum() = pwmNumber

    override fun getPwmFrequency() = frequencyHz
    override fun setPwmFrequency(frequencyHz: Int) {
        seeSaw.setPWMFreq(seeSawPin.toByte(), frequencyHz.toShort())
        this.frequencyHz = frequencyHz
    }

    override fun setValue(fraction: Float) {
        val dutyCycle = fraction * 0xFFFF
        seeSaw.analogWrite(seeSawPin.toByte(), truncate(dutyCycle).toInt().toShort(), true)
        currentValue = fraction
    }

    override fun getValue() = currentValue
}
