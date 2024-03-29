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

import com.diozero.util.SleepUtil
import java.time.Duration

/**
 * Handles displaying characters on segmented displays. The base conceit is a 14-segment display, with limits applied
 * to work with 7-segments.
 *
 * This is based on the Adafruit Segments library code.
 */
interface SegmentedDisplay {
    /**
     * Prints a string to the display(s). This is appended to any existing text.
     */
    fun print(value: String)

    /**
     * Prints a numeric value to the display(s). This is appended to any existing text.
     */
    fun print(value: Float, decimalPlaces: Int = 2)

    /**
     * Scroll the existing text by [count] characters. [count] must be positive.
     */
    fun scroll(count: Int = 1) {
        TODO("Not implemented yet")
    }

    /**
     * Directly set segment values for the [digit] in the display. The [digit] is zero-based, so 0 is the left-most
     * digit. The [hiValue] is the upper 7 bits of the segment value, and [lowValue] is the lower 7 bits. The
     * [lowValue] is not used for 7-segment displays.
     */
    fun setDigit(digit: Int, hiValue: Int, lowValue: Int? = null)

    /**
     * Print a scrolling value to the displays. Each character is appened to existing text at the [delay] interval. If
     * [loop] is true, the text will be repeated indefinitely.
     */
    fun marquee(text: String, delay: Duration = Duration.ofMillis(250), loop: Boolean = false) {
        val namos = delay.toNanos()
        do {
            text.forEach { c ->
                print(c.toString())
                SleepUtil.busySleep(namos)
            }
        } while (loop)
    }
}

val CHARS = listOf(
    0b00000000, 0b00000000, //
    0b01000000, 0b00000110, // !
    0b00000010, 0b00100000, // "
    0b00010010, 0b11001110, // #
    0b00010010, 0b11101101, // $
    0b00001100, 0b00100100, // %
    0b00100011, 0b01011101, // &
    0b00000100, 0b00000000, // '
    0b00100100, 0b00000000, // (
    0b00001001, 0b00000000, // )
    0b00111111, 0b11000000, // *
    0b00010010, 0b11000000, // +
    0b00001000, 0b00000000, // ,
    0b00000000, 0b11000000, // -
    0b00000000, 0b00000000, // .
    0b00001100, 0b00000000, // /
    0b00001100, 0b00111111, // 0
    0b00000000, 0b00000110, // 1
    0b00000000, 0b11011011, // 2
    0b00000000, 0b10001111, // 3
    0b00000000, 0b11100110, // 4
    0b00100000, 0b01101001, // 5
    0b00000000, 0b11111101, // 6
    0b00000000, 0b00000111, // 7
    0b00000000, 0b11111111, // 8
    0b00000000, 0b11101111, // 9
    0b00010010, 0b00000000, // :
    0b00001010, 0b00000000, // ;
    0b00100100, 0b01000000, // <
    0b00000000, 0b11001000, // =
    0b00001001, 0b10000000, // >
    0b01100000, 0b10100011, // ?
    0b00000010, 0b10111011, // @
    0b00000000, 0b11110111, // A
    0b00010010, 0b10001111, // B
    0b00000000, 0b00111001, // C
    0b00010010, 0b00001111, // D
    0b00000000, 0b11111001, // E
    0b00000000, 0b01110001, // F
    0b00000000, 0b10111101, // G
    0b00000000, 0b11110110, // H
    0b00010010, 0b00000000, // I
    0b00000000, 0b00011110, // J
    0b00100100, 0b01110000, // K
    0b00000000, 0b00111000, // L
    0b00000101, 0b00110110, // M
    0b00100001, 0b00110110, // N
    0b00000000, 0b00111111, // O
    0b00000000, 0b11110011, // P
    0b00100000, 0b00111111, // Q
    0b00100000, 0b11110011, // R
    0b00000000, 0b11101101, // S
    0b00010010, 0b00000001, // T
    0b00000000, 0b00111110, // U
    0b00001100, 0b00110000, // V
    0b00101000, 0b00110110, // W
    0b00101101, 0b00000000, // X
    0b00010101, 0b00000000, // Y
    0b00001100, 0b00001001, // Z
    0b00000000, 0b00111001, // [
    0b00100001, 0b00000000, // \
    0b00000000, 0b00001111, // ]
    0b00001100, 0b00000011, // ^
    0b00000000, 0b00001000, // _
    0b00000001, 0b00000000, // `
    0b00010000, 0b01011000, // a
    0b00100000, 0b01111000, // b
    0b00000000, 0b11011000, // c
    0b00001000, 0b10001110, // d
    0b00001000, 0b01011000, // e
    0b00000000, 0b01110001, // f
    0b00000100, 0b10001110, // g
    0b00010000, 0b01110000, // h
    0b00010000, 0b00000000, // i
    0b00000000, 0b00001110, // j
    0b00110110, 0b00000000, // k
    0b00000000, 0b00110000, // l
    0b00010000, 0b11010100, // m
    0b00010000, 0b01010000, // n
    0b00000000, 0b11011100, // o
    0b00000001, 0b01110000, // p
    0b00000100, 0b10000110, // q
    0b00000000, 0b01010000, // r
    0b00100000, 0b10001000, // s
    0b00000000, 0b01111000, // t
    0b00000000, 0b00011100, // u
    0b00100000, 0b00000100, // v
    0b00101000, 0b00010100, // w
    0b00101000, 0b11000000, // x
    0b00100000, 0b00001100, // y
    0b00001000, 0b01001000, // z
    0b00001001, 0b01001001, // {
    0b00010010, 0b00000000, // |
    0b00100100, 0b10001001, // }
    0b00000101, 0b00100000, // ~
    0b00111111, 0b11111111
)
val NUMBERS = listOf(
    0x3F, // 0
    0x06, // 1
    0x5B, // 2
    0x4F, // 3
    0x66, // 4
    0x6D, // 5
    0x7D, // 6
    0x07, // 7
    0x7F, // 8
    0x6F, // 9
    0x77, // a
    0x7C, // b
    0x39, // C
    0x5E, // d
    0x79, // E
    0x71, // F
    0x3D, // G
    0x76, // H
    0x30, // I
    0x1E, // J
    0x40, // -
    0x38, // L
    0x40, // -
    0x54, // n
    0x5C, // o
    0x73, // P
    0x67, // q
    0x50, // R
    0x6D, // S
    0x78, // t
    0x3E, // U
    0x1C, // v
    0x40, // -
    0x40, // -
    0x6E, // y
    0x40, // -
    0x40 // -
)
