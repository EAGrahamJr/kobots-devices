package crackers.kobots.devices.io

import com.diozero.api.DeviceInterface
import com.diozero.api.I2CDevice
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw.Companion.SignalMode

/**
 * STEMMA QT Gamepad by Adafruit, running off a Seesaw microcontroller. Each of the buttons and joystick values are
 * available as members of this class. The joystick values are 0-1023, and the buttons are true/false.
 *
 * Product page: https://www.adafruit.com/product/5743
 */
class GamepadQT(i2CDevice: I2CDevice = I2CDevice(DEFAULT_I2C_BUS, DEFAULT_I2C_ADDRESS)) : DeviceInterface {
    private val seeSaw = object : AdafruitSeeSaw(i2CDevice) {
        init {
            analogInputPins = intArrayOf(X_AXIS, Y_AXIS)
            pwmOutputPins = intArrayOf()
        }
    }
    private val INPUT_PINS = listOf(START_BUTTON, SELECT_BUTTON, A_BUTTON, B_BUTTON, X_BUTTON, Y_BUTTON)

    init {
        INPUT_PINS.forEach {
            seeSaw.pinMode(it, SignalMode.INPUT_PULLUP)
        }
        seeSaw.analogInputPins.forEach {
            seeSaw.pinMode(it, SignalMode.INPUT)
        }
    }

    val startButton: Boolean
        get() = !seeSaw.digitalRead(START_BUTTON)
    val selectButton: Boolean
        get() = !seeSaw.digitalRead(SELECT_BUTTON)
    val aButton: Boolean
        get() = !seeSaw.digitalRead(A_BUTTON)
    val bButton: Boolean
        get() = !seeSaw.digitalRead(B_BUTTON)
    val xButton: Boolean
        get() = !seeSaw.digitalRead(X_BUTTON)
    val yButton: Boolean
        get() = !seeSaw.digitalRead(Y_BUTTON)

    /**
     * All button values in the order of: start, select, a, b, x, y
     */
    val allButtons: List<Boolean>
        get() = seeSaw.digitalRead(INPUT_PINS.toIntArray()).values.toList().map { !it }

    val xAxis: Float
        get() = seeSaw.analogRead(seeSaw.analogInputPins[0].toByte()).toFloat()
    val yAxis: Float
        get() = seeSaw.analogRead(seeSaw.analogInputPins[1].toByte()).toFloat()

    class GamepadButtons(
        val start: Boolean,
        val select: Boolean,
        val a: Boolean,
        val b: Boolean,
        val x: Boolean,
        val y: Boolean
    )

    fun read(): GamepadButtons {
        val buttons = allButtons
        return GamepadButtons(buttons[0], buttons[1], buttons[2], buttons[3], buttons[4], buttons[5])
    }

    override fun close() {
        seeSaw.close()
    }

    companion object {
        const val DEFAULT_I2C_ADDRESS = 0x50
        const val DEFAULT_I2C_BUS = 1

        private const val SELECT_BUTTON = 0
        private const val START_BUTTON = 16
        private const val A_BUTTON = 5
        private const val B_BUTTON = 1
        private const val X_BUTTON = 6
        private const val Y_BUTTON = 2

        private const val X_AXIS = 14
        private const val Y_AXIS = 15
    }
}
