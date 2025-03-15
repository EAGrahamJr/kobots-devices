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

package crackers.kobots.devices.io

import com.diozero.api.DigitalInputDeviceInterface
import com.diozero.api.I2CDevice
import com.diozero.api.I2CDeviceInterface
import crackers.kobots.devices.lighting.WS2811
import java.awt.Color
import kotlin.experimental.and
import kotlin.math.abs
import kotlin.math.roundToInt

/**
 * A loose Kotlin translation of Python code from https://github.com/fourstix/Sparkfun_CircuitPython_QwiicTwist for the
 * Sparkfun [Qwiic Twist](https://www.sparkfun.com/products/15083).
 *
 * The basic operation is:
 * - the pretty light is exposed as a [WS2811] device
 * - this class is a [DigitalInputDeviceInterface] device for the button
 *   - along with some DSL functions for readability
 * - the encoder can be read (and reset) via several properties
 */
class QwiicTwist(device: I2CDeviceInterface = DEFAULT_I2C_DEVICE) : DigitalInputDeviceInterface {
    // because we can change addresses!
    private var i2cDevice: I2CDeviceInterface = device

    init {
        require(i2cDevice.writeBytes(REG_ID).let { i2cDevice.readByte() == ID }) { "Device ID does not match" }
    }

    /**
     * The on-board RGB LED.
     */
    val pixel: WS2811 = object : WS2811 {
        // our "buiffer" is just a single pixel
        private var pixel = Color.PINK
        private var buffer = Color.PINK

        // autowrite is alway true
        override var autoWrite: Boolean
            get() = true
            set(_) {}

        private var _brightness = 1f
        override var brightness: Float
            get() = _brightness
            set(v) {
                require(v in 0f..1f) { "Brightness value out of range (0.0 to 1.0)" }
                _brightness = v
                buffer = Color(
                    (pixel.red * v).roundToInt(),
                    (pixel.green * v).roundToInt(),
                    (pixel.blue * v).roundToInt()
                )
                show()
            }

        override fun fill(color: WS2811.PixelColor) {
            pixel = color.color
            brightness = color.brightness ?: brightness
            show()
        }

        override fun set(index: Int, color: WS2811.PixelColor) {
            require(index == 0) { "Index out of range (0)" }
            fill(color)
        }

        override fun set(start: Int, end: Int, color: WS2811.PixelColor) {
            throw UnsupportedOperationException("Not supported -- there's only one LED")
        }

        override fun set(start: Int, end: Int, colors: List<WS2811.PixelColor>) {
            throw UnsupportedOperationException("Not supported -- there's only one LED")
        }

        private fun show() {
            i2cDevice.writeBytes(REG_RED, buffer.red.toByte(), buffer.green.toByte(), buffer.blue.toByte())
        }

        // TODO **GET** the current color, since it can be changed by the connect deltas
    }

    override fun close() {
        pixel.off()
        i2cDevice.close()
    }

    override fun getValue() = pressed

    /**
     * DSL to test the button state. Note this is only intended for readability. Example:
     *
     * ````kotlin
     * if (twist button PRESSED) println("True")
     * ```
     */
    infix fun button(test: Boolean): Boolean = getValue() == test

    /**
     * Number of clicks. This is a signed value, so it can be negative. Setting this value will reset the encoder to
     * that value.
     */
    var count: Int
        get() = read16(REG_COUNT)
        set(v) {
            require(abs(v) <= 0xFFFF) { "Count value out of range (-65535 to 65535)" }
            write16(REG_COUNT, v)
        }

    /**
     * Manage the color delta for the RED, GREEN, and BLUE channels. Each "click" will change the color by the delta
     * amount.
     */
    var colorConnection: Triple<Int, Int, Int>
        get() {
            val red = read16(REG_RED_CONNECT)
            val green = read16(REG_GREEN_CONNECT)
            val blue = read16(REG_BLUE_CONNECT)
            return Triple(red, green, blue)
        }
        set(v) {
            require(v.first in -255..255) { "Red color connection value out of range (0 to 65535)" }
            require(v.second in -255..255) { "Green color connection value out of range (0 to 65535)" }
            require(v.third in -255..255) { "Blue color connection value out of range (0 to 65535)" }
            write16(REG_RED_CONNECT, v.first)
            write16(REG_GREEN_CONNECT, v.second)
            write16(REG_BLUE_CONNECT, v.third)
        }

    /**
     * Manage the board interrupt firing timeout. This is the amount of time, in milliseconds, that the board will wait
     * before firing an interrupt after the last encoder event.
     */
    var encoderInterruptTimeout: Int
        get() = read16(TURN_INT_TIMEOUT)
        set(v) {
            require(v in 0..0xFFFF) { "Encoder interrupt timeout value out of range (0 to 65535)" }
            write16(TURN_INT_TIMEOUT, v)
        }

    /**
     * Get the board version.
     */
    val version: Int
        get() = TODO()

    /**
     * Clear all the interrupt registers.
     */
    fun clearInterrupts() {
        i2cDevice.writeBytes(REG_STATUS, 0, 0)
    }

    /**
     * Changes the address of the board. This will close the connection to this board. It is up to the caller of this
     * method to reconnect to the new address.
     */
    fun changeAddress(newAddress: Int) {
        require(newAddress in 8..119) { "Address out of range (8 to 119)" }
        i2cDevice.writeBytes(CHANGE_ADDRESS, newAddress.toByte())
        i2cDevice.close()
    }

    /**
     * Has the knob moved.
     */
    val moved: Boolean
        get() = readAndClearBit(ENCODER_MOVED_BIT)

    /**
     * Has the button been pressed.
     */
    val pressed: Boolean
        get() = readAndClearBit(BUTTON_PRESSED_BIT)

    /**
     * Has the button been "clicked" (pressed and released?).
     */
    val clicked: Boolean
        get() = readAndClearBit(BUTTON_CLICKED_BIT)

    /**
     * Difference (number of clicks) between the last two encoder events. The register is cleared after reading.
     */
    val difference: Int
        get() = read16(REG_DIFFERENCE).also { write16(REG_DIFFERENCE, 0) }

    /**
     * Time in milliseconds since last turn.
     */
    val timeSinceLastMovement: Int
        get() = read16(REG_LAST_ENCODER_EVENT).also { write16(REG_LAST_ENCODER_EVENT, 0) }

    /**
     * Time in milliseconds since last button press (down and release).
     */
    val timeSinceLastPress: Int
        get() = read16(REG_LAST_BUTTON_EVENT).also { write16(REG_LAST_BUTTON_EVENT, 0) }

    /**
     * Read a status bit and immediately clear it.
     */
    private fun readAndClearBit(bit: Int): Boolean {
        i2cDevice.writeBytes(REG_STATUS)
        val status = i2cDevice.readByte()
        val moved = status and (1 shl bit).toByte()
        // clear that bit and write back to the register
        i2cDevice.writeBytes(REG_STATUS, status and (1 shl bit).inv().toByte())
        return moved != 0.toByte()
    }

    /**
     * Read a 16-bit value from the given register. Note we read LSB then MSB.
     */
    private fun read16(register: Byte): Int {
        i2cDevice.writeBytes(register)
        i2cDevice.readBytes(2).let { bytes ->
            return ((bytes[1].toInt() shl 8) or bytes[0].toInt())
        }
    }

    /**
     * Write a 16-bit value to the given register. Note we write LSB then MSB.
     */
    private fun write16(register: Byte, v: Int) {
        i2cDevice.writeBytes(register, (v and 0xFF).toByte(), ((v shr 8) and 0xFF).toByte())
    }

    companion object {
        const val DEFAULT_I2C_BUS = 1
        const val DEFAULT_I2C_ADDRESS = 0x3F
        const val ALTERNATE_I2C_ADDRESS = 0x3E

        val DEFAULT_I2C_DEVICE by lazy { I2CDevice(DEFAULT_I2C_BUS, DEFAULT_I2C_ADDRESS) }

        const val PRESSED = true

        const val ID = 0x5C.toByte() // ID returned from ID query

        const val REG_ID = 0x00.toByte() // ID register
        const val REG_STATUS = 0x01.toByte() // Status register -- see bits below
        const val REG_VERSION = 0x02.toByte() // Version register
        const val REG_ENABLE_INT = 0x04.toByte() // Enable interrupt register

        // get the stuff
        const val REG_COUNT = 0x05.toByte() // Count register
        const val REG_DIFFERENCE = 0x07.toByte() // Difference register
        const val REG_LAST_ENCODER_EVENT = 0x09.toByte() // Last encoder event register
        const val REG_LAST_BUTTON_EVENT = 0x0B.toByte() // Last button event register - TODO not working?

        // color registers
        const val REG_RED = 0x0D.toByte()
        const val REG_GREEN = 0x0E.toByte()
        const val REG_BLUE = 0x0F.toByte()

        // connect the amount of the LED to the clicks
        const val REG_RED_CONNECT = 0x10.toByte()
        const val REG_GREEN_CONNECT = 0x12.toByte()
        const val REG_BLUE_CONNECT = 0x14.toByte()

        // misc
        const val TURN_INT_TIMEOUT = 0x16.toByte()
        const val CHANGE_ADDRESS = 0x18.toByte()

        // bits
        const val BUTTON_CLICKED_BIT = 2
        const val BUTTON_PRESSED_BIT = 1
        const val ENCODER_MOVED_BIT = 0

        const val BUTTON_INT_ENABLE = 1
        const val ENCODER_INT_ENABLE = 0
    }
}
