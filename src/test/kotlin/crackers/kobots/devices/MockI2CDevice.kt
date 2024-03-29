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

package crackers.kobots.devices

import com.diozero.api.I2CDevice
import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Assertions
import java.util.*

/**
 * What it says on the label - this is a singleton instance
 */
object MockI2CDevice {
    /**
     * The responses to be returned on requests.
     */
    val responses = Stack<ByteArray>()

    /**
     * The collected requests as a single stream of bytes. This may include more than one "command".
     */
    val requests = mutableListOf<Byte>()

    val device = mockk<I2CDevice>().apply {
        val d = this

        // capture all output writes into the output buffer - note this will continue to append to the buffer
        every {
            d.writeByte(capture(requests))
        } answers {
            // do nothing
        }

        every {
            d.writeBytes(
                *varargAllByte {
                    requests += it
                    true
                }
            )
        } returns Unit

        every {
            d.writeByteData(any<Int>(), any<Int>())
        } answers {
            it.invocation.args.apply {
                requests += (get(0).toString().toInt() and 0xFF).toByte()
                requests += (get(1).toString().toInt() and 0xFF).toByte()
            }
        }
        every {
            d.writeByteData(any<Int>(), any<Byte>())
        } answers {
            it.invocation.args.apply {
                requests += (get(0).toString().toInt() and 0xFF).toByte()
                requests += (get(1).toString().toInt() and 0xFF).toByte()
            }
        }

        // read bytes: this will pop a response from the expected response stack
        val toRead = slot<Int>()
        every {
            d.readBytes(capture(toRead))
        } answers {
            if (responses.isEmpty()) {
                ByteArray(0)
            } else {
                responses.pop().also {
                    // validate that the number to be read is the size of the expected response
                    val readThisMany = toRead.captured
                    val expectingThisMany = it.size

                    Assertions.assertEquals(
                        expectingThisMany,
                        readThisMany,
                        "Number of bytes expected $expectingThisMany vs toRead $readThisMany"
                    )
                }
            }
        }
        every {
            d.readBytes(any<ByteArray>())
        } answers {
            val buffer = invocation.args[0] as ByteArray
            val nextResponse = responses.pop()
            val actualResponseSize = nextResponse.size
            Assertions.assertEquals(
                actualResponseSize,
                buffer.size,
                "Number of bytes expected $actualResponseSize vs buffer ${buffer.size}"
            )
            nextResponse.copyInto(buffer)
            actualResponseSize
        }
        every {
            d.close()
        } returns Unit
    }
}

fun FunSpec.clearBeforeTest() {
    beforeTest {
        MockI2CDevice.requests.clear()
        MockI2CDevice.responses.clear()
    }
}
