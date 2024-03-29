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
import com.diozero.devices.oled.SsdOledCommunicationChannel
import crackers.kobots.utilities.BYTE_MASK
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Image
import java.awt.color.ColorSpace
import java.awt.geom.Rectangle2D
import java.awt.image.BufferedImage
import java.awt.image.ColorConvertOp
import java.awt.image.DataBufferByte
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * Abstract B/W display.
 *
 * TODO Both C++ and Python use an in-memory buffer and only write to the display when that "region" is dirty
 * TODO Because Java has a separate image construct, is this necessary?
 */
abstract class GrayOled(
    private val delegate: SsdOledCommunicationChannel,
    val width: Int,
    val height: Int,
    val displayType: DisplayType,
    initializationSequence: IntArray = IntArray(0),
    reset: Boolean = true,
    initAutoShow: Boolean = false
) : DeviceInterface {

    enum class DisplayType(val pixelsPerByte: Int) {
        WHITE(1), BLACK(1), INVERSE(1), FOUR_BITS(2)
    }

    protected abstract val dataCommand: Int
    protected abstract val setRowCommand: Int
    protected abstract val setColumnCommand: Int
    protected val sendBuffer = mutableListOf<Int>()

    init {
        if (reset && initializationSequence.isNotEmpty()) command(initializationSequence)
    }

    override fun close() {
        clear() // effectively clears the screen buffer kinda
        delegate.close()
    }

    abstract var displayOn: Boolean
    abstract fun invertDisplay(invert: Boolean)
    open fun getNativeImageType() = BufferedImage.TYPE_BYTE_GRAY

    private var _autoShow: Boolean = initAutoShow

    private val BLACKOUT by lazy {
        BufferedImage(128, 128, BufferedImage.TYPE_BYTE_GRAY).also {
            with(it.graphics as Graphics2D) {
                color = Color.BLACK
                fill(Rectangle2D.Double(0.0, 0.0, width.toDouble(), height.toDouble()))
            }
        }
    }

    /**
     * If true, the display will be updated after every call to [display].
     */
    var autoShow: Boolean
        get() = _autoShow
        set(value) {
            _autoShow = value
        }

    /**
     * Basically displays a black rectangle, with optional dimensions.
     */
    fun clear() {
        display(BLACKOUT)
        show()
    }

    /**
     * Display an image: scales and converts the image into the internal buffer. If [autoShow] is true, the display
     * will be updated.
     */
    open fun display(image: BufferedImage): BufferedImage = scaleAndConvert(image).also {
        // put it in the buffer
        packBuffer(it)
        if (autoShow) show()
    }

    /**
     * Scale to the display size and convert the image to the native type.
     */
    protected open fun scaleAndConvert(image: BufferedImage): BufferedImage {
        val imageHt = image.height
        val imageWd = image.width

        // scale to fit
        val scaledImage =
            if (imageWd == width && imageHt == height) {
                image
            } else {
                val scale = min(width.toFloat() / imageWd, height.toFloat() / imageHt)
                val w = (scale * imageWd).roundToInt()
                val h = (scale * imageHt).roundToInt()

                val scaled = image.getScaledInstance(w, h, Image.SCALE_DEFAULT)
                val type = if (image.type != 0) image.type else BufferedImage.TYPE_USHORT_GRAY
                BufferedImage(width, height, type).apply {
                    createGraphics().apply {
                        drawImage(scaled, 0, 0, w, h, null)
                        dispose()
                    }
                }
            }

        // if the type already matches, just use it, otherwise convert to the default color space
        return if (scaledImage.type == getNativeImageType()) {
            scaledImage
        } else {
            ColorConvertOp(COLOR_SPACE, null).filter(scaledImage, null)
        }
    }

    /**
     * Set up the internal buffer for transfer to the display.
     */
    protected open fun packBuffer(image: BufferedImage) {
        sendBuffer.clear()

        // start grabbing pixels
        val rasterized = (image.raster.dataBuffer as DataBufferByte).data
        // TODO because there's no specific color type for b/w,
        // TODO the non-gray images will need to force the values to 0 or 1
        when (displayType) {
            DisplayType.WHITE -> {
                for (element in rasterized) sendBuffer += (element.toInt())
            }

            DisplayType.BLACK -> {
                for (element in rasterized) sendBuffer += ((element.toInt()).inv() and BYTE_MASK)
            }

            DisplayType.INVERSE -> {
                TODO("Haven't seen one of these")
            }

            DisplayType.FOUR_BITS -> {
                for (offset in rasterized.indices step 2) {
                    val hiPixel = rasterized[offset].convert4Bits()
                    val loPixel = rasterized[offset + 1].convert4Bits()

                    sendBuffer += ((hiPixel shl 4) and 0xF0) or (loPixel and 0x0F)
                }
            }
        }
    }

    /**
     * Set the cursor to the home position.
     *
     * TODO investigate cursor posiitioning for partial buffer transfers
     */
    protected fun home() {
        command(
            intArrayOf(
                setRowCommand,
                0,
                height - 1,
                setColumnCommand,
                0,
                (width / displayType.pixelsPerByte) - 1
            )
        )
    }

    private fun Byte.convert4Bits(): Int = this.toInt().let {
        if (it == 0 || it == 255) {
            it
        } else {
            (((it and 0xFF) * 4f) / 255).roundToInt()
        }
    }

    /**
     * Transfers the internal buffer to the display.
     */
    fun show() {
        // TODO make a copy of the current buffer and determine the offset/size of the dirty region

        // set the cursor to the home position and send the buffer
        home()
        sendBuffer.chunked(4096) { it.toIntArray() }.forEach {
            data(it)
        }
    }

    /**
     * Issue single command byte to OLED
     * @param c The single byte command
     */
    protected fun command(c: Int) = command(intArrayOf(c))

    /**
     * Issue multiple bytes of commands, using I2C or hard/soft SPI as needed.
     *  @param values the commands to write
     */
    protected fun command(values: IntArray) = writeBuffer(CMD_MODE, values)

    /**
     * Issue multiple bytes of data, using I2C or hard/soft SPI as needed.
     *  @param dataBuffer the commands to write
     */
    protected fun data(dataBuffer: IntArray) = writeBuffer(dataCommand, dataBuffer)

    /**
     * I
     */
    private fun writeBuffer(prefix: Int, buffer: IntArray) {
        val size = buffer.size + 1
        val remapped = ByteArray(size).apply {
            set(0, prefix.toByte())
            buffer.forEachIndexed { index, b -> set(index + 1, b.toByte()) }
        }
        delegate.write(remapped, 0, size)
    }

    companion object {
        const val CMD_MODE = 0x00
        const val BLACK = 0x0
        const val WHITE = 0xF

        private val COLOR_SPACE = ColorSpace.getInstance(ColorSpace.CS_GRAY)
    }
}
