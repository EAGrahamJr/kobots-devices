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

import java.awt.Color

/**
 * Defines [WS2811](https://cdn-shop.adafruit.com/datasheets/WS2811.pdf) aka **NeoPixels**.
 */
interface WS2811 {
    /**
     * Wrapper for colors that includes an optional white level for devices that support that. An optional [brightness]
     * can also be applied.
     */
    data class PixelColor(val color: Color, val white: Int = 0, val brightness: Float? = null) : Cloneable {
        public override fun clone() = PixelColor(color, white, brightness)
        fun same(color: Color) = color == this.color
    }

    var autoWrite: Boolean
    var brightness: Float

    /**
     * Shorthand for `fill(Color.BLACK)`
     */
    fun off() {
        fill(Color.BLACK)
    }

    /**
     * Fill the entire device with this color. If [autoWrite] is enabled, the results are immediately uploaded.
     */
    infix fun fill(color: PixelColor)

    /**
     * Fill the entire device with this color. If [autoWrite] is enabled, the results are immediately uploaded.
     */
    infix fun fill(color: Color) {
        fill(PixelColor(color))
    }

    operator fun plus(color: Color) {
        fill(PixelColor(color))
    }

    operator fun plus(color: PixelColor) {
        fill(color)
    }

    /**
     * Set an individual pixel (this is available as an _indexed_ value). If [autoWrite] is enabled, the results are
     * immediately uploaded.
     */
    operator fun set(index: Int, color: PixelColor)

    operator fun set(index: Int, color: Color) {
        set(index, PixelColor(color))
    }

    /**
     * Set a range of pixels to a color. If [autoWrite] is enabled, the results are immediately uploaded.
     */
    operator fun set(start: Int, end: Int, color: PixelColor)

    operator fun set(start: Int, end: Int, color: Color) {
        set(start, end, PixelColor(color))
    }

    /**
     * Set a range of pixels to a range of colors. The color list must be equal to or larger than the range specified.
     * If [autoWrite] is enabled, the results are * immediately uploaded.
     */
    operator fun set(start: Int, end: Int, colors: List<PixelColor>)
}
