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

import com.diozero.api.DeviceInterface
import com.diozero.api.I2CDevice
import com.diozero.api.I2CDeviceInterface
import crackers.kobots.devices.lighting.NeoPixel
import crackers.kobots.devices.lighting.WS2811
import crackers.kobots.devices.lighting.WS2811.PixelColor
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw

/**
 * Adafruit https://www.adafruit.com/product/4980
 */
class NeoKey(i2CDevice: I2CDeviceInterface = I2CDevice(DEFAULT_I2C_BUS, DEFAULT_I2C_ADDRESS)) :
    DeviceInterface,
    WS2811 {
    private val seeSaw = AdafruitSeeSaw(i2CDevice)

    val pixels = NeoPixel(seeSaw, 4, NEOPIX_DEVICE).apply {
        brightness = 0.2f
    }

    init {
        INPUT_PINS.forEach {
            seeSaw.pinMode(it, AdafruitSeeSaw.Companion.SignalMode.INPUT_PULLUP)
        }
    }

    // auto-write is always enabled here
    override var autoWrite: Boolean
        get() = true
        set(_) {}

    override var brightness: Float
        get() = pixels.brightness
        set(b) {
            pixels.brightness = b
        }

    /**
     * Read all the switches
     *
     * TODO for some reason, the read on a PULLUP is backwards
     */
    fun read(): List<Boolean> = seeSaw.digitalRead(INPUT_PINS.toIntArray()).values.toList().map { !it }

    /**
     * Get a button value.
     *
     * TODO for some reason, the read on a PULLUP is backwards
     */
    operator fun get(index: Int): Boolean = !seeSaw.digitalRead(INPUT_PINS[index])

    /**
     * Get the color of this key.
     */
    infix fun color(index: Int): PixelColor = pixels[index]

    /**
     * All the colors
     */
    fun colors(): List<PixelColor> = (0..pixels.size - 1).map { pixels[it] }

    override operator fun set(index: Int, color: PixelColor) {
        pixels[index] = color
    }

    override fun set(start: Int, end: Int, color: PixelColor) {
        pixels.set(start, end, color)
    }

    override fun set(start: Int, end: Int, colors: List<PixelColor>) {
        pixels.set(start, end, colors)
    }

    /**
     * Fill the entire device with this color. If [autoWrite] is enabled, the results are immediately uploaded.
     */
    override fun fill(color: PixelColor) {
        pixels.fill(color)
    }

    companion object {
        private val INPUT_PINS = (4 until 8).toList()
        private const val NEOPIX_DEVICE = 0x03.toByte()

        const val DEFAULT_I2C_ADDRESS = 0x30
        const val DEFAULT_I2C_BUS = 1
    }

    override fun close() {
        pixels.off()
        seeSaw.close()
    }
}
