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

import com.diozero.api.I2CDeviceInterface
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal
import kotlin.math.min

/**
 * TODO temporary since I only have one display
 */
class QwiicAlphanumericDisplay(devices: List<I2CDeviceInterface>) : HT16K33(devices), SegmentedDisplay {
    constructor() : this(listOf(DEFAULT_DEVICE))

    private var decimalOn = false
    private var colonOn = false

    /**
     * Get/set the state of the decimal point on the display.
     */
    var decimal: Boolean
        get() = decimalOn
        set(value) {
            decimalOn = value
            pixel(8, 1, decimalOn)
        }

    /**
     * Get/set the state of the colon on the display.
     */
    var colon: Boolean
        get() = colonOn
        set(value) {
            colonOn = value
            pixel(8, 0, colonOn)
        }

    /**
     * TODO currently only outputs directly to the display, no scrolling or anything
     */
    override fun print(value: String) {
        value.subSequence(0, min(value.length, 4)).forEachIndexed { index, c ->
            if (c == '.' || c == ':') {
                // TODO
            } else {
                writeCharToDigit(index, c)
            }
        }
        if (autoShow) show()
    }

    /**
     * Print a time to the display in hours:minutes. If [useAmPm] is true, the hours will be
     * displayed as 1-12 with AM/PM. If [colon] is true, a colon will be displayed between the two values.
     */
    fun clock(time: Temporal, colonOn: Boolean = true, useAmPm: Boolean = false) {
        require(ChronoUnit.HOURS.isSupportedBy(time) && ChronoUnit.MINUTES.isSupportedBy(time)) { "Time must have hours:minutes" }
        val hod = time.get(ChronoField.HOUR_OF_DAY)
        val hours = if (useAmPm) {
            time.get(ChronoField.HOUR_OF_AMPM).let {
                val s = it.toString()
                if (s.length < 2) " $s" else s
            }
        } else {
            hod.let {
                String.format("%02d", it)
            }
        }
        // time without the colon because it's 4 digits
        val semiFormatted = String.format("%s%02d", hours, time.get(ChronoField.MINUTE_OF_HOUR))
        print(semiFormatted)
        colon = colonOn
    }

    override fun print(value: Float, decimalPlaces: Int) {
        TODO()
    }

    override fun setDigit(digit: Int, hiValue: Int, lowValue: Int?) {
        TODO()
    }

    // temporary since I only have one display
    // 3f 00 0b 00 ab 00 0e 00 05 00 a5 00 01 00 00
    private fun writeCharToDigit(digit: Int, char: Char) {
        val (hiBits, lowBits) = SEG_CODES[char.code - 32]
        for (i in 0..7) {
            val mask = 1 shl i

            val showLo = (mask and lowBits) != 0
            setPixel(digit, i, showLo)

            val showHi = (mask and hiBits) != 0
            setPixel(digit + 4, i, showHi)
        }
    }

    companion object {
        // hi/lo bytes - the hi byte goes into the second set of 7 segments
        private val SEG_CODES = listOf(
            Pair(0b00000000, 0b00000000), // ' '
            Pair(0b00000100, 0b00001000), // '!'
            Pair(0b00000100, 0b00000010), // '"'
            Pair(0b00100101, 0b01001110), // '#'
            Pair(0b00100101, 0b01101101), // '$'
            Pair(0b01001000, 0b00100100), // '%'
            Pair(0b00011010, 0b01011001), // '&'
            Pair(0b00000100, 0b00000000), // '''
            Pair(0b00000000, 0b00111001), // '('
            Pair(0b00000000, 0b00001111), // ')'
            Pair(0b01111110, 0b00000000), // '*'
            Pair(0b00100101, 0b01000000), // '+'
            Pair(0b01000000, 0b00000000), // ','
            Pair(0b00000001, 0b01000000), // '-'
            Pair(0b00000000, 0b00000000), // '.'
            Pair(0b01001000, 0b00000000), // '/'
            Pair(0b00000000, 0b00111111), // '0'
            Pair(0b00001000, 0b00000110), // '1'
            Pair(0b00000001, 0b01011011), // '2'
            Pair(0b00000001, 0b01001111), // '3'
            Pair(0b00000001, 0b01100110), // '4'
            Pair(0b00000001, 0b01101101), // '5'
            Pair(0b00000001, 0b01111101), // '6'
            Pair(0b00101000, 0b00000001), // '7'
            Pair(0b00000001, 0b01111111), // '8'
            Pair(0b00000001, 0b01100111), // '9'
            Pair(0b00000000, 0b00000000), // ':'
            Pair(0b01000100, 0b00000000), // ';'
            Pair(0b00011000, 0b00000000), // '<'
            Pair(0b00000001, 0b01001000), // '='
            Pair(0b00100010, 0b00000000), // '>'
            Pair(0b00100001, 0b00000011), // '?'
            Pair(0b00000101, 0b00111011), // '@'
            Pair(0b00000001, 0b01110111), // 'A'
            Pair(0b00100101, 0b00001111), // 'B'
            Pair(0b00000000, 0b00111001), // 'C'
            Pair(0b00100100, 0b00001111), // 'D'
            Pair(0b00000001, 0b01111001), // 'E'
            Pair(0b00000001, 0b01110001), // 'F'
            Pair(0b00000001, 0b00111101), // 'G'
            Pair(0b00000001, 0b01110110), // 'H'
            Pair(0b00100100, 0b00001001), // 'I'
            Pair(0b00000000, 0b00011110), // 'J'
            Pair(0b00011000, 0b01110000), // 'K'
            Pair(0b00000000, 0b00111000), // 'L'
            Pair(0b00001010, 0b00110110), // 'M'
            Pair(0b00010010, 0b00110110), // 'N'
            Pair(0b00000000, 0b00111111), // 'O'
            Pair(0b00000001, 0b01110011), // 'P'
            Pair(0b00010000, 0b00111111), // 'Q'
            Pair(0b00010001, 0b01110011), // 'R'
            Pair(0b00000011, 0b00001101), // 'S'
            Pair(0b00100100, 0b00000001), // 'T'
            Pair(0b00000000, 0b00111110), // 'U'
            Pair(0b01001000, 0b00110000), // 'V'
            Pair(0b01010000, 0b00110110), // 'W'
            Pair(0b01011010, 0b00000000), // 'X'
            Pair(0b00101010, 0b00000000), // 'Y'
            Pair(0b01001000, 0b00001001), // 'Z'
            Pair(0b00000000, 0b00111001), // '['
            Pair(0b00010010, 0b00000000), // '\'
            Pair(0b00000000, 0b00001111), // ']'
            Pair(0b01010000, 0b00000000), // '^'
            Pair(0b00000000, 0b00001000), // '_'
            Pair(0b00000010, 0b00000000), // '`'
            Pair(0b00000001, 0b01011111), // 'a'
            Pair(0b00010000, 0b01111000), // 'b'
            Pair(0b00000001, 0b01011000), // 'c'
            Pair(0b01000001, 0b00001110), // 'd'
            Pair(0b00000000, 0b01111001), // 'e'
            Pair(0b00000000, 0b01110001), // 'f'
            Pair(0b00000011, 0b00001111), // 'g'
            Pair(0b00000001, 0b01110100), // 'h'
            Pair(0b00100000, 0b00000000), // 'i'
            Pair(0b00000000, 0b00001110), // 'j'
            Pair(0b00111100, 0b00000000), // 'k'
            Pair(0b00100100, 0b00000000), // 'l'
            Pair(0b00100001, 0b01010100), // 'm'
            Pair(0b00010000, 0b01010000), // 'n'
            Pair(0b00000001, 0b01011100), // 'o'
            Pair(0b00001000, 0b01110001), // 'p'
            Pair(0b00010001, 0b01100011), // 'q'
            Pair(0b00000000, 0b01010000), // 'r'
            Pair(0b00000011, 0b00001101), // 's'
            Pair(0b00000000, 0b01111000), // 't'
            Pair(0b00000000, 0b00011100), // 'u'
            Pair(0b01000000, 0b00010000), // 'v'
            Pair(0b01010000, 0b00010100), // 'w'
            Pair(0b01011010, 0b00000000), // 'x'
            Pair(0b00000101, 0b00001110), // 'y'
            Pair(0b01001000, 0b00001001), // 'z'
            Pair(0b01000010, 0b01001001), // '{'
            Pair(0b00100100, 0b00000000), // '|'
            Pair(0b00011001, 0b00001001), // '}'
            Pair(0b00000001, 0b01010010) // '~'
        )
    }
}
