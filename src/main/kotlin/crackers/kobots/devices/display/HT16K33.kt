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

package crackers.kobots.devices.display

import com.diozero.api.DeviceInterface
import com.diozero.api.I2CDevice
import com.diozero.api.I2CDeviceInterface
import crackers.kobots.utilities.asByte
import crackers.kobots.utilities.hex
import org.slf4j.LoggerFactory
import kotlin.experimental.and
import kotlin.experimental.inv
import kotlin.experimental.or
import kotlin.math.roundToInt

/**
 * I2C-based LED matrix driver. Inspired by Adafruit's [HT16K33](https://github.com/adafruit/Adafruit_CircuitPython_HT16K33) library
 */
abstract class HT16K33(val devices: List<I2CDeviceInterface>) : DeviceInterface {
    private val logger = LoggerFactory.getLogger(HT16K33::class.java.simpleName)

    override fun close() {
        devices.forEach(I2CDeviceInterface::close)
    }

    enum class BlinkRate {
        OFF, FAST, MEDIUM, SLOW
    }

    // each device gets a 17-byte buffer (1 for the "register" byte) and make sure it's filled with zeros
    private val buffer = ByteArray(devices.size * BUFFER_SIZE) { 0x00 }

    init {
        devices.forEachIndexed { index, device ->
            writeCommand(index, CMD_SYSTEM_SETUP or OSCILLATOR)
        }
    }

    private var _brightness = 1.0f
    private var _blinkRate = BlinkRate.OFF
    private var displayOn = true

    /**
     * Whether to immediately show the buffer on the display(s) after a change or not. This is **`false`** by default
     * as it causes a write operation for **every** pixel update.
     */
    var autoShow = false

    /**
     * Get/set the brightness for the display(s).
     */
    var brightness: Float
        get() = _brightness
        set(value) {
            require(value in 0.0f..1.0f)
            val b = ((value * 15).roundToInt() and 0x0F).toByte()
            devices.forEachIndexed { index, device -> writeCommand(index, CMD_BRIGHTNESS or b) }
        }

    /**
     * Get/set whether the display(s) are on or off.
     */
    var on: Boolean
        get() = displayOn
        set(value) {
            displayOn = value
            setBlinking()
        }

    /**
     * Get/set the blink-rate for the display(s).
     */
    var blinkRate: BlinkRate
        get() = _blinkRate
        set(b) {
            _blinkRate = b
            displayOn = true
            setBlinking()
        }

    private fun setBlinking() {
        val setting = (_blinkRate.ordinal shl 1).toByte()
        devices.forEachIndexed { index, device -> writeCommand(index, BLINK_CMD or displayOn.asByte() or setting) }
    }

    /**
     * Show the buffer on the display(s).
     */
    fun show() {
        devices.forEachIndexed { index, device ->
            val offset = index * BUFFER_SIZE
            val slice = buffer.sliceArray(offset until offset + BUFFER_SIZE).toTypedArray().toByteArray()
            if (logger.isDebugEnabled) logger.debug("Writing to device $index: ${slice.hex()}")
            device.writeBytes(*slice)
        }
    }

    /**
     * Fill the display(s) with either on or off pixels.
     */
    fun fill(onOff: Boolean) {
        val fill = if (onOff) 0xFF.toByte() else 0x00.toByte()
        devices.forEachIndexed { index, device ->
            val offset = index * BUFFER_SIZE
            for (i in 1 until BUFFER_SIZE) {
                buffer[offset + i] = fill
            }
        }
        if (autoShow) show()
    }

    /**
     * Set a pixel on or off based on the x,y coordinates, based on 7-segment display coordinates.
     *
     * TODO should this be protected or internal?
     */
    fun pixel(x: Int, y: Int, color: Boolean) {
        // TODO simply this
        val offset = (x.floorDiv(16) + y.floorDiv(8)) * BUFFER_SIZE
        val addr1 = 2 * (y % 8) + ((x % 16).floorDiv(8))
        val addr = (addr1 % 16) + offset
        val mask = (1 shl (x % 8)).toByte()

        // set or clear (remember to offset by 1)
        buffer[addr + 1] = if (color) buffer[addr + 1] or mask else buffer[addr + 1] and mask.inv()

        if (autoShow) show()
    }

    private fun writeCommand(device: Int, command: Byte) {
        devices[device].writeByte(command)
    }

    companion object {
        private const val BUFFER_SIZE = 17
        const val DEFAULT_I2C_ADDRESS = 0x70
        val DEFAULT_DEVICE by lazy { I2CDevice(1, DEFAULT_I2C_ADDRESS) }

        internal const val BLINK_CMD = 0x80.toByte()
        internal const val CMD_DISPLAYON = 0x01.toByte()
        internal const val CMD_BRIGHTNESS = 0xE0.toByte()
        internal const val CMD_SYSTEM_SETUP = 0x20.toByte()
        internal const val OSCILLATOR = 0x01.toByte()
    }
}
