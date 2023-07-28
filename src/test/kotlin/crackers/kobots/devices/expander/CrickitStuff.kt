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

package crackers.kobots.devices.expander

import crackers.kobots.devices.MockI2CDevice
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw
import java.util.*

/**
 * Stuff for testing
 */
fun initProperties() {
    System.setProperty(
        com.diozero.sbc.DeviceFactoryHelper.DEVICE_FACTORY_PROP,
        "com.diozero.internal.provider.mock.MockDeviceFactory"
    )
}

fun initRaspberryPi(): Stack<ByteArray>.() -> Unit = {
    push(byteArrayOf(0x0f, 0x75, 0x27, 0x01))
    push(byteArrayOf(AdafruitSeeSaw.Companion.DeviceType.SAMD09_HW_ID_CODE.chipId.toByte()))
}

fun initOtherBoardType(): Stack<ByteArray>.() -> Unit = {
    push(byteArrayOf(0x0f, 0x75, 0x27, 0x01))
    push(byteArrayOf(AdafruitSeeSaw.Companion.DeviceType.ATTINY817_HW_ID_CODE.chipId.toByte()))
}

internal val testHat: CRICKITHatSeesaw by lazy {
    MockI2CDevice.responses.apply(initRaspberryPi())
    CRICKITHatSeesaw(MockI2CDevice.device).also {
        MockI2CDevice.requests.clear()
    }
}

internal val testHatWithOtherBackpack by lazy {
    MockI2CDevice.responses.apply(initOtherBoardType())
    CRICKITHatSeesaw(MockI2CDevice.device).also {
        MockI2CDevice.requests.clear()
    }
}
