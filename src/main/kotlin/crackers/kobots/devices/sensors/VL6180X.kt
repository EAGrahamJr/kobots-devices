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

package crackers.kobots.devices.sensors

import com.diozero.api.I2CDevice
import com.diozero.api.I2CDeviceInterface
import com.diozero.api.NoSuchDeviceException
import com.diozero.devices.DistanceSensorInterface
import com.diozero.devices.LuminositySensorInterface
import com.diozero.util.SleepUtil.busySleep
import crackers.kobots.devices.sensors.VL6180X.Companion.ALSGain.GAIN_10
import crackers.kobots.utilities.toBytes
import crackers.kobots.utilities.toShort
import java.time.Duration
import kotlin.experimental.or

/**
 * Close-range "time of flight" proximity sensor on an I2C board, works for ranges < 200 mm.
 *
 * Shamelessly cribbed from the Adafruit CircuitPython driver at
 * https://github.com/adafruit/Adafruit_CircuitPython_VL6180X/blob/main/adafruit_vl6180x.py
 *
 * * [Product description](https://www.adafruit.com/product/3316)
 * * [Datasheet](https://cdn-learn.adafruit.com/assets/assets/000/037/608/original/VL6180X_datasheet.pdf)
 */
class VL6180X(private val delegate: I2CDeviceInterface) : LuminositySensorInterface, DistanceSensorInterface {
    @JvmOverloads
    constructor(controller: Int = 1, address: Int = DEFAULT_I2C_ADDR) : this(I2CDevice(controller, address))

    val continuousModeEnabled: Boolean
        get() = (readByte(SYSRANGE_START).toInt() and 0x02) != 0

    private val HUNDRED_MILLIS = Duration.ofMillis(100).toNanos()

    init {
        readByte(IDENTIFICATION_MODEL_ID).toByte().also { id ->
            if (id != DEVICE_ID) {
                throw NoSuchDeviceException("Unable to locate device (incorrect id: $id(")
            }
        }

        // private settings from page 24 of app note
        writeByte(0x0207, 0x01)
        writeByte(0x0208, 0x01)
        writeByte(0x0096, 0x00)
        writeByte(0x0097, 0xFD.toByte())
        writeByte(0x00E3, 0x00)
        writeByte(0x00E4, 0x04)
        writeByte(0x00E5, 0x02)
        writeByte(0x00E6, 0x01)
        writeByte(0x00E7, 0x03)
        writeByte(0x00F5, 0x02)
        writeByte(0x00D9, 0x05)
        writeByte(0x00DB, 0xCE.toByte())
        writeByte(0x00DC, 0x03)
        writeByte(0x00DD, 0xF8.toByte())
        writeByte(0x009F, 0x00)
        writeByte(0x00A3, 0x3C)
        writeByte(0x00B7, 0x00)
        writeByte(0x00BB, 0x3C)
        writeByte(0x00B2, 0x09)
        writeByte(0x00CA, 0x09)
        writeByte(0x0198, 0x01)
        writeByte(0x01B0, 0x17)
        writeByte(0x01AD, 0x00)
        writeByte(0x00FF, 0x05)
        writeByte(0x0100, 0x05)
        writeByte(0x0199, 0x05)
        writeByte(0x01A6, 0x1B)
        writeByte(0x01AC, 0x3E)
        writeByte(0x01A7, 0x1F)
        writeByte(0x0030, 0x00)

        // Recommended : Public registers - See data sheet for more detail

        // Enables polling for 'New Sample ready' when measurement completes
        writeByte(0x0011, 0x10)
        // Set the averaging sample period (compromise between lower noise and increased execution time)
        writeByte(0x010A, 0x30)
        // Sets the light and dark gain (upper nibble). Dark gain should not be changed.
        writeByte(0x003F, 0x46)
        // sets the # of range measurements after which auto calibration of system is performed
        writeByte(0x0031, 0xFF.toByte())
        // Set ALS integration time to 100ms
        writeByte(0x0040, 0x63)
        // perform a single temperature calibration of the ranging sensor
        writeByte(0x002E, 0x01)

        // Optional: Public registers - See data sheet for more detail

        // Set default ranging inter-measurement period to 100ms
        writeByte(0x001B, 0x09)
        // Set default ALS inter-measurement period to 500ms
        writeByte(0x003E, 0x31)
        // Configures interrupt on 'New Sample Ready threshold event
        writeByte(0x0014, 0x24)

        writeByte(SYSTEM_FRESH_OUT_OF_RESET, 0x00)

        // reset sensor that crashed in continuous mode
        if (continuousModeEnabled) {
            stopContinuousMode()
            busySleep(HUNDRED_MILLIS)
        }

        // activate the history buffer
        writeByte(SYSTEM_HISTORY_CTRL, 0x01)
    }

    override fun close() {
        delegate.close()
    }

    override fun getDistanceCm(): Float = range / 10f

    override fun getLuminosity(): Float = getLuminosity(GAIN_10)

    fun getLuminosity(gain: ALSGain): Float {
        // set up the interrupt configuration
        val reg = (readByte(SYSTEM_INTERRUPT_CONFIG).toInt() and 0x38.inv()) or 32
        writeByte(SYSTEM_INTERRUPT_CONFIG, reg.toByte())

        // 100 ms integration period
        writeByte(SYSALS_INTEGRATION_PERIOD_HI, 0)
        writeByte(SYSALS_INTEGRATION_PERIOD_LO, 100)

        // analog gain
        writeByte(SYSALS_ANALOGUE_GAIN, gain.setting or 0x40)

        // start ALS and wait for the interrupt
        writeByte(SYSALS_START, 0x01)
        while (luxInterrupt() != 4)
            busySleep(50)

        // read lux and "calibrate" it
        val lux = readInt(RESULT_ALS_VAL) * .32f
        // clear the interrupt
        writeByte(SYSTEM_INTERRUPT_CLEAR, 0x07)

        return gain / lux
    }

    private fun luxInterrupt() = (readByte(RESULT_INTERRUPT_STATUS_GPIO).toInt() shr 3) and 0x07

    /**
     * Stops continuous ranging mode.
     */
    fun stopContinuousMode() {
        writeByte(SYSRANGE_START, 0x01)
    }

    /**
     * Starts continuous ranging mode. The [period] is the time delay between measurements, in milliseconds; the value
     * will be floored to the nearest 10 milliseconds (setting to 157 ms sets it to 150 ms). Range is 10 - 2550 ms.
     */
    fun startContinuousMode(period: Int) {
        if (period !in 10..2550) throw IllegalArgumentException("Period '$period' is out of range (10-2550).")
        val data = period.floorDiv(10) - 1
        writeByte(SYSRANGE_INTERMEASUREMENT_PERIOD, data.toByte())
        // start mode
        writeByte(SYSRANGE_START, 0x03)
    }

    /**
     * Returns the current range in millimeters.
     */
    val range: Int
        get() = if (continuousModeEnabled) readRangeContinuous() else readRangeSingle()

    /**
     * Returns the range history buffer: there are 16 history entries available, each entry is the range in mm.
     */
    val rangeFromHistory: List<Int>
        get() = if (!rangeHistoryEnabled) {
            emptyList()
        } else {
            (0 until 16).map { age ->
                readByte(RESULT_HISTORY_BUFFER_0 + age).toInt()
            }
        }

    /**
     * Returns true if the range history buffer is enabled.
     */
    val rangeHistoryEnabled: Boolean
        get() = readByte(SYSTEM_HISTORY_CTRL).toInt() and 0x01 == 1

    private fun readRangeSingle(): Int {
        while (readByte(RESULT_RANGE_STATUS).toInt() and 0x01 == 0)
            busySleep(50)
        writeByte(SYSRANGE_START, 0x01)
        return readRangeContinuous()
    }

    private fun readRangeContinuous(): Int {
        // wiat for the interrupt
        while (readByte(RESULT_INTERRUPT_STATUS_GPIO).toInt() and 0x04 == 0)
            busySleep(50)
        return readByte(RESULT_RANGE_VAL).toInt().also {
            // clear the interrupt
            writeByte(SYSTEM_INTERRUPT_CLEAR, 0x07)
        }
    }

    private fun readByte(address: Int): UByte {
        val (hi, lo) = address.toBytes()
        delegate.writeBytes(hi, lo)
        return delegate.readByte().toUByte()
    }

    private fun readInt(address: Int): Int {
        val (hi, lo) = address.toBytes()
        delegate.writeBytes(hi, lo)
        val buffer = ByteArray(2)
        delegate.readBytes(buffer)
        return buffer.toShort()
    }

    private fun writeByte(address: Int, data: Byte) {
        val (hi, lo) = address.toBytes()
        delegate.writeBytes(hi, lo, data)
    }

    companion object {
        const val DEVICE_ID = 0xB4.toByte()
        private const val IDENTIFICATION_MODEL_ID = 0x000

        private const val SYSTEM_HISTORY_CTRL = 0x012
        private const val SYSTEM_INTERRUPT_CONFIG = 0x014
        private const val SYSTEM_INTERRUPT_CLEAR = 0x015
        private const val SYSTEM_FRESH_OUT_OF_RESET = 0x016

        private const val SYSRANGE_START = 0x018
        private const val SYSRANGE_INTERMEASUREMENT_PERIOD = 0x01B
        private const val SYSRANGE_PART_TO_PART_RANGE_OFFSET = 0x024

        private const val SYSALS_START = 0x038
        private const val SYSALS_ANALOGUE_GAIN = 0x03F
        private const val SYSALS_INTEGRATION_PERIOD_HI = 0x040
        private const val SYSALS_INTEGRATION_PERIOD_LO = 0x041

        private const val RESULT_RANGE_STATUS = 0x04D
        private const val RESULT_INTERRUPT_STATUS_GPIO = 0x04F
        private const val RESULT_ALS_VAL = 0x050
        private const val RESULT_HISTORY_BUFFER_0 = 0x052
        private const val RESULT_RANGE_VAL = 0x062

        const val DEFAULT_I2C_ADDR = 0x29

        enum class ALSGain(val setting: Byte, val divisor: Float) {
            GAIN_1(6, 1f),
            GAIN_1_25(5, 1.25f),
            GAIN_1_67(4, 1.67f),
            GAIN_2_5(3, 2.5f),
            GAIN_5(2, 5f),
            GAIN_10(1, 10f),
            GAIN_20(0, 20f),
            GAIN_40(7, 40f);

            operator fun div(lux: Float) = lux / divisor
        }

        enum class Errors(val code: Byte) {
            NONE(0), SYSERR_1(1), SYSERR_5(5), ECE_FAIL(6), NO_CONVERGE(6), RANGE_IGNORE(8), SNR(11), RAW_UNDERFLOW(12),
            RAW_OVERFLOW(13), RANGE_UNDERFLOW(14), RANGE_OVERFLOW(15)
        }
    }
}
