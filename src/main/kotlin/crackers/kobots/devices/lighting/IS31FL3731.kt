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

import com.diozero.api.DeviceInterface
import com.diozero.api.I2CDevice
import com.diozero.api.I2CDeviceInterface
import com.diozero.util.SleepUtil
import crackers.kobots.devices.inRange
import crackers.kobots.devices.toInt
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.log2
import kotlin.math.roundToInt

/**
 * Represents an IS31LF3731 charlieplex IC. All pixel operations are **direct write** to the device, no buffering.
 * The display has (by default) 8 addressable "frames" (memory buffers) that contain the display information.
 *
 * Some base methods are protected so that the individual users of this chip can adjust inputs based on the device.
 *
 * Additional information from the [docs](https://www.lumissil.com/assets/pdf/core/IS31FL3731_DS.pdf)
 */
abstract class IS31FL3731(private val i2CDevice: I2CDeviceInterface = DEFAULT_DEVICE, frames: Iterable<Int> = (0..7)) :
    DeviceInterface {
    abstract val width: Int
    abstract val height: Int
    private val currentBank = AtomicInteger(-1)
    private val frame = AtomicInteger(0)

    init {
        // Clear config: sets to Picture Mode, no audio sync, maintains sleep
        sleep(true)
        setBank(CONFIG_BANK)
        i2CDevice.writeBytes(*ByteArray(14) { 0 })
        val enableData = ByteArray(19) { if (it == 0) ENABLE_OFFSET.toByte() else 0xFF.toByte() }
        val fillData = ByteArray(25) { 0 }
        (frames).forEach { frame ->
            setBank(frame)
            i2CDevice.writeBytes(*enableData)
            for (row in 0..5) {
                fillData[0] = (COLOR_OFFSET + row * 24).toByte()
                i2CDevice.writeBytes(*fillData)
            }
        }
        sleep(false)
    }

    override fun close() {
        sleep(true)
        i2CDevice.close()
    }

    /**
     * Manage display driver memory bank.
     */
    protected fun setBank(bank: Int) {
        if (currentBank.get() != bank) {
            currentBank.set(bank)
            i2CDevice.writeByteData(BANK_ADDRESS, bank.toByte())
        }
    }

    protected fun readBank() = i2CDevice.readByteData(BANK_ADDRESS).toInt()

    protected fun readFromRegister(bank: Int, register: Int): Int {
        setBank(bank)
        return i2CDevice.readByteData(register).toInt()
    }

    protected fun writeToRegister(bank: Int, register: Int, value: Int) {
        setBank(bank)
        i2CDevice.writeByteData(register, value.toByte())
    }

    protected fun mode(mode: Int) = writeToRegister(CONFIG_BANK, MODE_REGISTER, mode)

    // public stuff ---------------------------------------------------------------------------------------------------
    fun sleep(goToSleep: Boolean) {
        writeToRegister(CONFIG_BANK, SHUTDOWN_REGISTER, if (goToSleep) 0 else 1)
    }

    fun reset() {
        sleep(true)
        SleepUtil.sleepMillis(10)
        sleep(false)
    }

    /**
     * Start "autoplay" (rotate through) the number of [frames] (default all), with a limited number of [loops]
     * (default `0`=infinite) and an approximate [delay] in milliseconds.
     *
     * **NOTE** the delay must be less than `704` due to register limitations. Values < `11` are effectively `0`.
     */
    @JvmOverloads
    fun autoPlay(delay: Int = 0, loops: Int = 0, frames: Int = 0) {
        if (delay == 0) {
            mode(PICTURE_MODE)
            return
        }

        val dly = delay.inRange("delay", (1..704))
            .floorDiv(11).inRange("delay", 1..64) // why 11?
        loops.inRange("loops", FOUR_BITS_RANGE)
        frames.inRange("frames", FOUR_BITS_RANGE)

        writeToRegister(CONFIG_BANK, AUTOPLAY1_REGISTER, (loops shl 4) or frames)
        writeToRegister(CONFIG_BANK, AUTOPLAY2_REGISTER, dly % 64)
        mode(AUTOPLAY_MODE or frame.get())
    }

    /**
     * Starts the automatic "breathe" fade in/out
     */
    protected fun breathe() {
        writeToRegister(CONFIG_BANK, BREATH2_REGISTER, 0)
    }

    /**
     * Fade in and out
     */
    @JvmOverloads
    protected fun fade(fadeIn: Int? = null, fadeOut: Int? = null, pause: Int = 0) {
        if (fadeIn == null && fadeOut == null) {
            breathe()
            return
        }

        val fin = log2((fadeIn ?: fadeOut)!!.toDouble() / 26.0).toInt().inRange("fadeIn", FOUR_BITS_RANGE)
        val fout = log2((fadeOut ?: fadeIn)!!.toDouble() / 26.0).toInt().inRange("fadeOut", FOUR_BITS_RANGE)
        val ps = log2(pause / 26.0).toInt().inRange("pause", FOUR_BITS_RANGE)

        writeToRegister(CONFIG_BANK, BREATH1_REGISTER, (fout shl 4) or fin)
        writeToRegister(CONFIG_BANK, BREATH2_REGISTER, (1 shl 4) or ps)
    }

    /**
     * Specifically show a frame - does _not_ set the current default frame.
     */
    fun showFrame(f: Int) {
        writeToRegister(CONFIG_BANK, FRAME_REGISTER, f)
    }

    /**
     * Set the current default frame, optionally [show]ing it.
     */
    @JvmOverloads
    fun setFrame(f: Int, show: Boolean = false) {
        frame.set(f.inRange("frame", FOUR_BITS_RANGE))
        if (show) writeToRegister(CONFIG_BANK, FRAME_REGISTER, f)
    }

    fun getFrame() = frame.get()

    /**
     * Enable/disable the audio sync functionality.
     */
    protected fun audioSync(enable: Boolean) = writeToRegister(CONFIG_BANK, AUDIOSYNC_REGISTER, if (enable) 1 else 0)

    /**
     * Set up the audio play.
     */
    @JvmOverloads
    protected fun audioPlay(sampleRate: Int, audioGain: Int = 0, agcEnable: Boolean = false, agcFast: Boolean = false) {
        if (sampleRate == 0) {
            mode(PICTURE_MODE)
            return
        }

        sampleRate.floorDiv(46).inRange("sampleRate", 1..256).run {
            writeToRegister(CONFIG_BANK, ADC_REGISTER, this % 256)
        }

        audioGain.floorDiv(3).inRange("audioGain", FOUR_BITS_RANGE).run {
            writeToRegister(CONFIG_BANK, GAIN_REGISTER, (agcEnable.toInt() shl 3) or (agcFast.toInt() shl 4) or this)
        }
        mode(AUDIOPLAY_MODE)
    }

    fun getBlink() = (readFromRegister(CONFIG_BANK, BLINK_REGISTER) and 0x07) * 270

    /**
     * Set and enable blink. [rate] in milliseconds is a multiple of `270` up to `1890`, or `0` to disable.
     */
    @JvmOverloads
    fun setBlink(rate: Int = 0) {
        writeToRegister(
            CONFIG_BANK,
            BLINK_REGISTER,
            if (rate == 0) 0x00 else (rate.inRange("rate", (270..1890)).floorDiv(270) and 0x07) or 0x08
        )
    }

    /**
     * Fills the entire display with a _white_ color at the indicated [brightness] percentage (1 to 100) and selected
     * [frame].
     */
    @JvmOverloads
    fun fill(brightness: Int, blink: Boolean = false, frame: Int = getFrame()) {
        setBank(frame)
        brightness.inRange("brightness", 1..100).let {
            val b = (brightness * 2.55f).roundToInt().toByte()
            val data = ByteArray(25) { b }

            MAGICFILLRANGE.forEach { row ->
                data[0] = (COLOR_OFFSET + row * 24).toByte()
                i2CDevice.writeBytes(*data)
            }
        }
        // TODO this doesn't seem to work
//        blink.toInt().let { data ->
//            (0..18).forEach { col ->
//                writeToRegister(frame, _BLINK_OFFSET + col, data)
//            }
//        }
    }

    /**
     * Set a pixel to a [color] (brightness), with optional [blink]ing and [frame]
     */
    @JvmOverloads
    internal fun pixel(x: Int, y: Int, color: Int, blink: Boolean = false, frame: Int = getFrame()) {
        if (x !in (0..width) || y !in (0..height)) return
        color.inRange("color", 0..255)
        val address = pixelAddress(x, y)
        writeToRegister(frame, COLOR_OFFSET + address, color)

        // TODO verify some working variation of this in Python
//        val addr = address / 8
//        val bit = address % 8
//        var bits = readFromRegister(frame, _BLINK_OFFSET + addr)
//        bits = if (blink) {
//            bits or (1 shl bit)
//        } else {
//            bits and (1 shl bit).inv()
//        }
//        writeToRegister(frame, _BLINK_OFFSET + addr, bits)
    }

    @JvmOverloads
    protected fun image(img: Any, blink: Boolean = false, frame: Int = getFrame()) {
        TODO("Adafruit source indicates 'Python image' as the input")
    }

    open fun pixelAddress(x: Int, y: Int) = x + y * 16

    companion object {
        const val DEFAULT_ADDRESS = 0x74
        private val DEFAULT_DEVICE by lazy { I2CDevice(1, DEFAULT_ADDRESS) }

        // TODO magic number range
        private val MAGICFILLRANGE = 0..6
        private val FOUR_BITS_RANGE = 0..7

        internal const val MODE_REGISTER = 0x00
        internal const val FRAME_REGISTER = 0x01
        internal const val AUTOPLAY1_REGISTER = 0x02
        internal const val AUTOPLAY2_REGISTER = 0x03

        // actually DISPLAY_OPTION
        internal const val BLINK_REGISTER = 0x05
        internal const val AUDIOSYNC_REGISTER = 0x06
        internal const val BREATH1_REGISTER = 0x08
        internal const val BREATH2_REGISTER = 0x09
        internal const val SHUTDOWN_REGISTER = 0x0A
        internal const val GAIN_REGISTER = 0x0B
        internal const val ADC_REGISTER = 0x0C

        internal const val CONFIG_BANK = 0x0B
        internal const val BANK_ADDRESS = 0xFD

        internal const val PICTURE_MODE = 0x00
        internal const val AUTOPLAY_MODE = 0x08
        internal const val AUDIOPLAY_MODE = 0x18

        internal const val ENABLE_OFFSET = 0x00
        internal const val BLINK_OFFSET = 0x12

        // PWM register
        internal const val COLOR_OFFSET = 0x24
    }
}
