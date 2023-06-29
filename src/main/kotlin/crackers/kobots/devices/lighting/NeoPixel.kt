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

import crackers.kobots.devices.microcontroller.AdafruitSeeSaw
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw.Companion.NEOPIXEL_BASE
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw.Companion.NEOPIXEL_BUF
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw.Companion.NEOPIXEL_BUF_LENGTH
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw.Companion.NEOPIXEL_PIN
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw.Companion.NEOPIXEL_SHOW
import crackers.kobots.devices.to2Bytes
import crackers.kobots.devices.twoBytesAndBuffer
import kotlin.concurrent.withLock

/**
 * NeoPixel aka [WS2811] handling via the Adafruit SeeSaw. This is available in several implementations.
 *
 * TODO add support for using "direct access" PWM pin?
 */
class NeoPixel(
    private val seeSaw: AdafruitSeeSaw,
    numPixels: Int,
    seesawPin: Byte,
    bitsPerPixel: Int = 3
) : PixelBuf(numPixels, "GRB" + if (bitsPerPixel == 4) "W" else "", autoWriteEnabled = true) {
    init {
        seeSaw.write(NEOPIXEL_BASE, NEOPIXEL_PIN, byteArrayOf(seesawPin))
        seeSaw.writeShort(NEOPIXEL_BASE, NEOPIXEL_BUF_LENGTH, (bitsPerPixel * numPixels).toShort())
    }

    private val step = OUTPUT_BUFFER_SIZE - 2
    private lateinit var lastBuffer: ByteArray

    override fun sendBuffer(buffer: ByteArray) = seeSaw.lock.withLock {
        var changeOffset = -1
        // find the memory segments that changed since last time
        val sendThis = if (!::lastBuffer.isInitialized) {
            lastBuffer = ByteArray(buffer.size)
            changeOffset = 0
            buffer
        } else if (lastBuffer.contentEquals(buffer)) {
            return
        } else {
            var lastIndex = 0
            buffer.forEachIndexed { index, byte ->
                if (byte != lastBuffer[index]) {
                    if (changeOffset < 0) changeOffset = index
                    lastIndex = index
                }
            }
            buffer.sliceArray(changeOffset..lastIndex)
        }
        buffer.copyInto(lastBuffer)

        sendThis.toList().chunked(step).forEachIndexed { index, chunk: List<Byte> ->
            val offset = (index * step + changeOffset).to2Bytes()
            val outputBuffer = twoBytesAndBuffer(offset.first, offset.second, chunk.toByteArray())
            seeSaw.write(NEOPIXEL_BASE, NEOPIXEL_BUF, outputBuffer)
        }
        seeSaw.write(NEOPIXEL_BASE, NEOPIXEL_SHOW)
        Unit
    }

    companion object {
        // magic buffer size as determined by Adafruit
        private const val OUTPUT_BUFFER_SIZE = 24
    }
}
