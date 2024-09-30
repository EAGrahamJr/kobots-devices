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

package crackers.kobots.devices.lighting

import crackers.kobots.devices.inRange
import crackers.kobots.devices.lighting.WS2811.PixelColor
import java.awt.Color
import kotlin.math.roundToInt

/**
 * A set of one or more [WS2811] addressable-LEDs.
 *
 * A re-implementation of the "pure Python" Adafruit PixelBuf class, which is a re-implementation of the base Adafruit
 * `pixelbuf` implementation.
 *
 * Note that some difference exist: for example, this relies on the base Java classes to represent colors vs the
 * Python `ColorUnion` construct that allows for 3 different types of "colors". Also, unless otherwise configured,
 * the usual `Gamma 8` color-correction is applied.
 *
 * TODO dotStar implementation is probably incorrect - needs device to test with
 */
abstract class PixelBuf(
    val size: Int, // size
    val byteOrder: String = "BGR",
    brightness: Float = 1f,
    autoWriteEnabled: Boolean = false,
    val applyGamma: Boolean = true,
    header: ByteArray? = null,
    trailer: ByteArray? = null
) : WS2811 {
    private val bpp: Int = byteOrder.length
    private val dotstarMode: Boolean
    private val hasWhite: Boolean
    private val colorOrder: List<Int>

    private val bufferOffset: Int
    private val effectiveSize: Int
    private val pixelStep: Int

    private val pixelBuffer: ByteArray
    private val currentColors: Array<PixelColor> = Array(size) { PixelColor(Color.BLACK, 0) }

    private val BUFFER_RANGE = 0 until size

    private var _autoWrite = autoWriteEnabled
    override var autoWrite: Boolean
        get() = _autoWrite
        set(b) {
            _autoWrite = b
        }

    private fun Color.corrected() =
        let {
            Color(gamma8Correction[it.red], gamma8Correction[it.green], gamma8Correction[it.blue])
        }

    open val gamma8Correction = listOf(
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2,
        2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5,
        5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10,
        10, 10, 11, 11, 11, 12, 12, 13, 13, 13, 14, 14, 15, 15, 16, 16,
        17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 24, 24, 25,
        25, 26, 27, 27, 28, 29, 29, 30, 31, 32, 32, 33, 34, 35, 35, 36,
        37, 38, 39, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 50,
        51, 52, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 66, 67, 68,
        69, 70, 72, 73, 74, 75, 77, 78, 79, 81, 82, 83, 85, 86, 87, 89,
        90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 109, 110, 112, 114,
        115, 117, 119, 120, 122, 124, 126, 127, 129, 131, 133, 135, 137, 138, 140, 142,
        144, 146, 148, 150, 152, 154, 156, 158, 160, 162, 164, 167, 169, 171, 173, 175,
        177, 180, 182, 184, 186, 189, 191, 193, 196, 198, 200, 203, 205, 208, 210, 213,
        215, 218, 220, 223, 225, 228, 231, 233, 236, 239, 241, 244, 247, 249, 252, 255,
    )

    /**
     * Manage how bright things are
     */
    private var _brightness: Float = 0f
    override var brightness: Float
        get() = _brightness
        set(b) {
            if (b < 0f || b > 1f) throw IllegalArgumentException("'brightness' is out of range (0.0-1.0)")
            _brightness = b
            val currentAutoWrite = _autoWrite
            _autoWrite = false
            currentColors.clone().forEachIndexed { i, c -> set(i, PixelColor(c.color, c.white, b)) }
            _autoWrite = currentAutoWrite
            if (_autoWrite) show()
        }

    init {
        byteOrder.length.inRange("byteOrder", 0..4)
        val r = byteOrder.indexOf("R").also {
            if (it < 0) throw IllegalArgumentException("byteOrder does not contain 'R'")
        }
        val g = byteOrder.indexOf("G").also {
            if (it < 0) throw IllegalArgumentException("byteOrder does not contain 'R'")
        }
        val b = byteOrder.indexOf("B").also {
            if (it < 0) throw IllegalArgumentException("byteOrder does not contain 'R'")
        }
        colorOrder = when {
            byteOrder.contains("W") -> {
                hasWhite = true
                dotstarMode = false
                listOf(r, g, b, byteOrder.indexOf("W"))
            }

            byteOrder.contains("P") -> {
                hasWhite = false
                dotstarMode = true
                val lum = byteOrder.indexOf("P")
                // TODO check this - seems odd
                // this makes no fucking sense because the original "parse" method is static?
                // NB - this shifts the bytes for the colors by one so the brightness can be set in the first byte for
                // each pixel
                listOf(r + 1, g + 1, b + 1, 0)
            }

            else -> {
                hasWhite = false
                dotstarMode = false
                listOf(r, g, b)
            }
        }

        pixelStep = if (dotstarMode) 4 else bpp
        effectiveSize = pixelStep * size
        val baseSize = effectiveSize + (header?.size ?: 0) + (trailer?.size ?: 0)

        pixelBuffer = ByteArray(baseSize)
        // if there's a header
        bufferOffset = if (header != null) {
            header.copyInto(pixelBuffer)
            header.size
        } else {
            0
        }
        // if there's a trailer
        trailer?.copyInto(pixelBuffer, bufferOffset + size)

        // pre-set the brightness value
        if (dotstarMode) {
            for (i in bufferOffset..effectiveSize step 4) pixelBuffer[i] = DOTSTAR_LED_START_FULL_BRIGHT
        }
        _brightness = brightness
    }

    /**
     * Fill the entire device with this color. If [autoWrite] is enabled, the results are immediately uploaded.
     */
    override infix fun fill(color: PixelColor) {
        set(0, size - 1, color)
    }

    /**
     * Set an individual pixel (this is available as an _indexed_ value). If [autoWrite] is enabled, the results are
     * immediately uploaded.
     */
    override operator fun set(index: Int, color: PixelColor) {
        setItem(index, parseColor(color))
        currentColors[index] = color
        if (_autoWrite) show()
    }

    /**
     * Set a range of pixels to a color (end is **inclusive**). If [autoWrite] is enabled, the results are
     * immediately uploaded.
     */
    override operator fun set(start: Int, end: Int, color: PixelColor) {
        val parsed = parseColor(color)
        (start..end).forEach {
            setItem(it, parsed)
            currentColors[it] = color
        }
        if (_autoWrite) show()
    }

    /**
     * Set a range of pixels to a range of colors (end is **inclusive**). The color list must be equal to or larger
     * than the range specified. If [autoWrite] is enabled, the results are immediately uploaded.
     */
    override operator fun set(start: Int, end: Int, colors: List<PixelColor>) {
        require(colors.size >= end - start + 1) { "List of colors does not match range." }
        (start..end).forEach {
            setItem(it, parseColor(colors[it]))
            currentColors[it] = colors[it]
        }
        if (_autoWrite) show()
    }

    /**
     * Current color for the given pixel.
     */
    operator fun get(index: Int) = currentColors[index]

    /**
     * All the current colors. This is a clone, so any changes will not have effect.
     */
    fun get(): Array<PixelColor> = currentColors.clone()

    /**
     * Immutable operator - changing these colors has no effect.
     */
    operator fun iterator(): Iterator<PixelColor> =
        object : Iterator<PixelColor> {
            var current = 0
            override fun hasNext() = current + 1 < size
            override fun next() = currentColors[++current].clone()
        }

    /**
     * Sends the current pixel buffer to the device.
     */
    fun show() {
        sendBuffer(pixelBuffer)
    }

    protected fun Byte.brightness(b: Float): Byte = (this.toUByte().toFloat() * b).roundToInt().toByte()

    /**
     * Sets up an individual pixel element, with whiteness stuff and brightness
     */
    protected fun setItem(index: Int, color: PixelBufColor) {
        val offset = index.inRange("pixelIndex", BUFFER_RANGE) * bpp + bufferOffset
        val pixelBrightness = color.bright ?: _brightness

        if (bpp == 4) {
            // scale white if not dotStar
            val w = (color.white * (if (!dotstarMode) pixelBrightness else 1f)).roundToInt().toByte()
            pixelBuffer[offset + colorOrder[3]] = w
        }

        pixelBuffer[offset + colorOrder[0]] = color.red.brightness(pixelBrightness)
        pixelBuffer[offset + colorOrder[1]] = color.green.brightness(pixelBrightness)
        pixelBuffer[offset + colorOrder[2]] = color.blue.brightness(pixelBrightness)
    }

    protected abstract fun sendBuffer(buffer: ByteArray)

    /**
     * Dork with white values based on the setup.
     */
    protected fun parseColor(pixelColor: PixelColor): PixelBufColor {
        val color = pixelColor.color.let { if (applyGamma) it.corrected() else it }
        val whiteValue = pixelColor.white
        val bright = pixelColor.brightness

        val useWhite = hasWhite && Color.red == Color.green && Color.green == Color.blue

        // adjust white value
        val w = (
            if (bpp == 4) {
                // LED startframe is three "1" bits, followed by 5 brightness bits
                // then 8 bits for each of R, G, and B. The order of those 3 are configurable and
                // vary based on hardware
                if (dotstarMode) {
                    ((whiteValue * 31) and 0b00011111) or DOTSTAR_LED_START
                } else {
                    if (useWhite) {
                        whiteValue
                    } else {
                        0
                    }
                }
            }
            // not usable
            else {
                0
            }
            ).toByte()

        return if (useWhite) {
            PixelBufColor(0, 0, 0, w, bright)
        } else {
            PixelBufColor(color.red.toByte(), color.green.toByte(), color.blue.toByte(), w, bright)
        }
    }

    protected class PixelBufColor(val red: Byte, val green: Byte, val blue: Byte, val white: Byte, val bright: Float?)

    companion object {
        const val DOTSTAR_LED_START_FULL_BRIGHT = 0xFF.toByte()
        const val DOTSTAR_LED_START = 0b11100000
    }
}
