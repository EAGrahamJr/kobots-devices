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

/**
 * This was not completed in Diozero library
 */
class I2cCommunicationChannel(val device: I2CDevice) : SsdOledCommunicationChannel {
    val bufferSize = 1024

    override fun write(vararg commands: Byte) {
        // TODO Check I2C transaction size limit
        device.writeBytes(*commands)
    }

    override fun write(buffer: ByteArray, offset: Int, length: Int) {
        // TODO Check I2C transaction size limit
        val data = ByteArray(length)
        System.arraycopy(buffer, offset, data, 0, length)
        device.writeBytes(*data)
    }

    override fun close() {
        device.close()
    }
}
