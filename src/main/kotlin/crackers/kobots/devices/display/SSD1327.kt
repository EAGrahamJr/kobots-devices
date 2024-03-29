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

import com.diozero.api.I2CDevice
import com.diozero.devices.oled.SsdOledCommunicationChannel
import com.diozero.devices.oled.SsdOledCommunicationChannel.I2cCommunicationChannel

/**
 * https://learn.adafruit.com/adafruit-grayscale-1-5-128x128-oled-display?view=all
 *
 * - Arduino
 *   - https://github.com/adafruit/Adafruit_SSD1327
 *   - https://github.com/adafruit/Adafruit-GFX-Library
 *
 * Python - https://github.com/adafruit/Adafruit_CircuitPython_SSD1327
 *
 * Check out https://github.com/OmniXRI/Pi_Pico_OLED_SSD1327_I2C
 */
class SSD1327(delegate: SsdOledCommunicationChannel, autoShow: Boolean = false) :
    GrayOled(delegate, HEIGHT, WIDTH, DisplayType.FOUR_BITS, initSequence(128, 128), true, autoShow) {

    /**
     * Default constructor for convenience.
     */
    constructor() : this(I2cCommunicationChannel(I2CDevice(DEFAULT_I2C_BUS, QWIIC_I2C_ADDRESS)), false)

    override val dataCommand: Int = DATA_MODE
    override val setColumnCommand: Int = SET_COL_ADDR
    override val setRowCommand: Int = SET_ROW_ADDR

    private var _displayOn: Boolean = false

    override var displayOn: Boolean
        get() = _displayOn
        set(on) {
            // enable/disable the VDD regulator, too
            command(
                if (on) {
                    intArrayOf(SET_FN_SELECT_A, 0x01, SET_DISP or 0x01)
                } else {
                    intArrayOf(SET_FN_SELECT_A, 0x00, SET_DISP)
                }
            )
            _displayOn = on
        }

    override fun invertDisplay(invert: Boolean) {
        command(if (invert) SET_DISP_INVERT else SET_DISP_NORMAL)
    }

    override fun close() {
        displayOn = false
        command(intArrayOf(SET_FN_SELECT_A, 0x00))
        super.close()
    }

    companion object {
        var HEIGHT = 128
        var WIDTH = 128

        internal const val CMD_MODE = 0x00
        internal const val DATA_MODE = 0x40

        internal const val SET_COL_ADDR = 0x15
        internal const val SET_SCROLL_DEACTIVATE = 0x2E
        internal const val SET_ROW_ADDR = 0x75
        internal const val SET_CONTRAST = 0x81
        internal const val SET_SEG_REMAP = 0xA0
        internal const val SET_DISP_START_LINE = 0xA1
        internal const val SET_DISP_OFFSET = 0xA2
        internal const val SET_DISP_NORMAL = 0xA4
        internal const val SET_DISP_INVERT = 0xA7

        //        const val DISPLAYALLON = 0xA5
//        const val DISPLAYALLOFF = 0xA6
        internal const val SET_MUX_RATIO = 0xA8
        internal const val SET_FN_SELECT_A = 0xAB
        internal const val SET_DISP = 0xAE // private in SsdOled

        //        const val DISPLAYON = 0xAF      // private in SsdOled
        internal const val SET_PHASE_LEN = 0xB1
        internal const val SET_DISP_CLK_DIV = 0xB3
        internal const val SET_SECOND_PRECHARGE = 0xB6
        internal const val SET_GRAYSCALE_TABLE = 0xB8
        internal const val SET_GRAYSCALE_LINEAR = 0xB9
        internal const val SET_PRECHARGE = 0xBC
        internal const val SET_VCOM_DESEL = 0xBE
        internal const val SET_FN_SELECT_B = 0xD5
        internal const val SET_COMMAND_LOCK = 0xFD

        internal fun initSequence(height: Int, width: Int) =
            Math.floorDiv((128 - width), 4).let { elements ->
                intArrayOf(
                    SET_COMMAND_LOCK, 0x12,
                    SET_DISP,
                    SET_DISP_START_LINE, 0x00,
                    SET_DISP_OFFSET, 0x0,
                    SET_SEG_REMAP, 0x51,
                    SET_MUX_RATIO, height - 1,
                    SET_FN_SELECT_A, 0x01,
                    SET_PHASE_LEN, 0x51,
                    SET_DISP_CLK_DIV, 0x01,
                    SET_PRECHARGE, 0x08,
                    SET_VCOM_DESEL, 0x07,
                    SET_SECOND_PRECHARGE, 0x01,
                    SET_FN_SELECT_B, 0x62,
                    SET_GRAYSCALE_LINEAR,
                    SET_CONTRAST, 0x7f,
                    SET_DISP_NORMAL,
                    SET_ROW_ADDR, 0x00, height - 1,
                    SET_COL_ADDR, elements, 63 - elements,
                    SET_SCROLL_DEACTIVATE,
                    SET_DISP or 0x01
                )
            }

        // Adafruit default address and device
        const val QWIIC_I2C_ADDRESS = 0x3D
        const val DEFAULT_I2C_BUS = 1
    }
}
