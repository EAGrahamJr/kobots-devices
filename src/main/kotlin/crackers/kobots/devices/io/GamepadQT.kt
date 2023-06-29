package crackers.kobots.devices.io

import com.diozero.api.*
import com.diozero.internal.spi.*
import com.diozero.sbc.BoardPinInfo
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw
import crackers.kobots.devices.microcontroller.SeesawAnalogInputDevice
import crackers.kobots.devices.microcontroller.SeesawDigitalDevice
import crackers.kobots.devices.microcontroller.SeesawDigitalPort

/**
 * STEMMA QT Gamepad by Adafruit. Based on the ubiquitous 12-button keypad and rnning off a Seesaw microcontroller.
 * Each of the buttons and joustick values areavailable as members of this class.
 *
 * Product page: https://www.adafruit.com/product/5743
 */
class GamepadQT(i2CDevice: I2CDevice = I2CDevice(DEFAULT_I2C_BUS, DEFAULT_I2C_ADDRESS)) : DeviceInterface {

    private val factory = GamepadDeviceFactory(i2CDevice)

    val startButton: DigitalInputDevice by lazy { DigitalInputDevice(factory, 16) }
    val selectButton: DigitalInputDevice by lazy { DigitalInputDevice(factory, 9) }
    val aButton: DigitalInputDevice by lazy { DigitalInputDevice(factory, 5) }
    val bButton: DigitalInputDevice by lazy { DigitalInputDevice(factory, 1) }
    val xButton: DigitalInputDevice by lazy { DigitalInputDevice(factory, 6) }
    val yButton: DigitalInputDevice by lazy { DigitalInputDevice(factory, 2) }
    val xAxis: AnalogInputDevice by lazy { AnalogInputDevice(factory, 2001) }
    val yAxis: AnalogInputDevice by lazy { AnalogInputDevice(factory, 2002) }

    override fun close() {
        factory.close()
    }

    companion object {
        const val DEFAULT_I2C_ADDRESS = 0x50
        const val DEFAULT_I2C_BUS = 1
        const val NAME = "GamepadQT"
    }
}

private class GamepadDeviceFactory(i2CDevice: I2CDevice) :
    AbstractDeviceFactory(GamepadQT.NAME),
    GpioDeviceFactoryInterface,
    AnalogInputDeviceFactoryInterface {

    private val seeSaw: AdafruitSeeSaw = GamepadSeesaw(i2CDevice)
    override fun getName() = GamepadQT.NAME

    override fun getBoardPinInfo() = BoardPinInfo().apply {
        val gpioPinModes = setOf(DeviceMode.DIGITAL_INPUT)
        listOf(16, 9, 5, 1, 6, 2).forEachIndexed { index, pin ->
            val info = makePinInfo("Button", index + 1001, pin, gpioPinModes)
            addGpioPinInfo(info)
        }
        val joystickModes = setOf(DeviceMode.ANALOG_INPUT)
        listOf(14, 15).forEachIndexed { index, pin ->
            val info = makePinInfo("Joystick", pin, index + 2001, joystickModes)
            addAdcPinInfo(info)
        }
    }

    override fun createDigitalInputDevice(
        key: String,
        pinInfo: PinInfo,
        pud: GpioPullUpDown,
        trigger: GpioEventTrigger
    ): GpioDigitalInputDeviceInterface {
        val delegate = SeesawDigitalPort(seeSaw, pinInfo.physicalPin)
        return SeesawDigitalDevice(key, this, pinInfo.deviceNumber, delegate).apply {
            // TODO: set pull up/down
            // TODO implement trigger/listeners with IRQ
        }
    }

    override fun createDigitalOutputDevice(
        key: String?,
        pinInfo: PinInfo?,
        initialValue: Boolean
    ): GpioDigitalOutputDeviceInterface {
        throw UnsupportedOperationException("Not implemented")
    }

    override fun createDigitalInputOutputDevice(
        key: String?,
        pinInfo: PinInfo?,
        mode: DeviceMode?
    ): GpioDigitalInputOutputDeviceInterface {
        throw UnsupportedOperationException("Not implemented")
    }

    override fun createAnalogInputDevice(key: String, pinInfo: PinInfo): AnalogInputDeviceInterface {
        val delegate = SeesawDigitalPort(seeSaw, pinInfo.physicalPin)
        return SeesawAnalogInputDevice(key, this, pinInfo.deviceNumber, delegate)
    }

    private val ANALOG_MAX = 1023f
    private fun makePinInfo(
        type: String,
        deviceId: Int,
        pin: Int,
        pinModes: Collection<DeviceMode>
    ) = PinInfo(type, name, pin, deviceId, "$type-$deviceId", pinModes, ANALOG_MAX)

    private class GamepadSeesaw(
        i2CDevice: I2CDevice = I2CDevice(
            GamepadQT.DEFAULT_I2C_BUS,
            GamepadQT.DEFAULT_I2C_ADDRESS
        )
    ) :
        AdafruitSeeSaw(i2CDevice) {
        init {
            analogInputPins = intArrayOf(14, 15)
        }
    }
}
