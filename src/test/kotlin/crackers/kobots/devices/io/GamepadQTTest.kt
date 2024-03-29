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

import crackers.kobots.devices.MockI2CDevice
import crackers.kobots.devices.clearBeforeTest
import crackers.kobots.devices.expander.initRaspberryPi
import crackers.kobots.devices.microcontroller.AdafruitSeeSaw
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class GamepadQTTest : FunSpec(

    {
        MockI2CDevice.responses.apply(initRaspberryPi())
        val gamepad = GamepadQT(MockI2CDevice.device)
        clearBeforeTest()

        context("Gampepad buttons") {
            test("A Button") {
                // mock the bytes in the seesaw register
                MockI2CDevice.responses.push(byteArrayOf(0x00, 0x00, 0x08, 0x00))
                // read the button
                gamepad.aButton shouldBe true
                MockI2CDevice.requests shouldContainExactly readDigitalInputCommand
            }
            test("Start button") {
                // mock the bytes in the seesaw register
                MockI2CDevice.responses.push(byteArrayOf(0x00, 0x00, 0x00, 0x01))
                // read the button
                gamepad.startButton shouldBe true
                MockI2CDevice.requests shouldContainExactly readDigitalInputCommand
            }
        }
        context("Gamepad joysticks") {
            test("Y Axis") {
                // mock the bytes in the seesaw register
                MockI2CDevice.responses.apply {
                    push(byteArrayOf(3, 0xFE.toByte()))
                    push(byteArrayOf(0, 4))
                }
                // read the button
                gamepad.yAxis shouldBe 4
                gamepad.yAxis shouldBe 1022

                val offset = (AdafruitSeeSaw.ADC_CHANNEL_OFFSET + 1).toByte()
                MockI2CDevice.requests shouldContainExactly listOf(
                    AdafruitSeeSaw.ADC_BASE,
                    offset,
                    AdafruitSeeSaw.ADC_BASE,
                    offset
                )
            }
        }
    }
)

private val readDigitalInputCommand = listOf(AdafruitSeeSaw.GPIO_BASE, AdafruitSeeSaw.GPIO_BULK)
