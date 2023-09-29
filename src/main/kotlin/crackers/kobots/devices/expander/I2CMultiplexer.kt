package crackers.kobots.devices.expander

import com.diozero.api.DeviceInterface
import com.diozero.api.I2CDevice
import com.diozero.api.I2CDeviceInterface
import org.slf4j.LoggerFactory
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * TCA9548A/PCA9548 I2C Multiplexer.
 *
 * * [Adafruit product](https://www.adafruit.com/product/2717)
 * * [STEMMA QT pinout](https://www.adafruit.com/product/5626)
 * * [Datasheet](https://cdn-learn.adafruit.com/assets/assets/000/115/917/original/pca9548a.pdf?1666013231)
 */
class I2CMultiplexer(
    val numberOfChannels: Int = 8,
    private val i2cDevice: I2CDevice = I2CDevice(1, DEFAULT_I2C_DEVICE)
) : DeviceInterface {
    private val devices = mutableMapOf<Pair<Int, Int>, I2CDeviceInterface>()
    private val provisionedDevices = mutableMapOf<Int, I2CDeviceInterface>()
    private val logger = LoggerFactory.getLogger("I2CMultiplexer")

    // device access requires a lock to prevent other devices from "grabbing" the bus
    private val lock = ReentrantLock()

    /**
     * Get the I2C device for the given [channel] and [deviceAddress]. Due to the way the multiplexer works, there
     * may be timing issues with the underlying I2C bus, so additional error handling may be necessary.
     */
    fun getI2CDevice(channel: Int, deviceAddress: Int): I2CDeviceInterface = lock.withLock {
        require(channel in 0 until numberOfChannels) { "Channel must be between 0 and ${numberOfChannels - 1}" }
        return devices.computeIfAbsent(channel to deviceAddress) {
            val childDevice = provisionedDevices.computeIfAbsent(deviceAddress) {
                logger.info("Provisioning device at address $deviceAddress")
                I2CDevice(i2cDevice.controller, deviceAddress)
            }
            logger.info("Provisioning channel $channel for device at address $deviceAddress")
            ChannelDevice(i2cDevice, channel, childDevice, lock)
        }
    }

    override fun close() {
        devices.clear()
        i2cDevice.close()
    }

    /**
     * Wraps the I2C "bus" in a "proxy" that tells the multiplexer to select the channel before executing the command.
     * This is a bit of a hack, but it works.
     *
     * Note: this can't be a proxy because there are multiple "signatures" that end up confusing the proxy.
     */
    private class ChannelDevice(
        private val multiplexer: I2CDevice,
        private val channel: Int,
        private val device: I2CDeviceInterface,
        private val lock: ReentrantLock
    ) : I2CDeviceInterface {

        /**
         * Tell the multiplexer to select the channel, then execute the block, then deselect the channel.
         */
        private fun <R> channelSelector(executionBlock: () -> R): R = lock.withLock {
            return try {
                multiplexer.writeByte((1 shl channel).toByte())
                executionBlock()
            } finally {
                multiplexer.writeByte(0)
            }
        }

        override fun close() {
            // no op
        }

        override fun readByte(): Byte = channelSelector { device.readByte() }
        override fun readBytes(buffer: ByteArray): Int = channelSelector { device.readBytes(buffer) }
        override fun readByteData(register: Int): Byte = channelSelector { device.readByteData(register) }
        override fun readWordData(register: Int): Short = channelSelector { device.readWordData(register) }
        override fun readI2CBlockData(register: Int, buffer: ByteArray): Int =
            channelSelector { device.readI2CBlockData(register, buffer) }

        override fun writeByte(value: Byte) = channelSelector { device.writeByte(value) }
        override fun writeBytes(vararg buffer: Byte) = channelSelector { device.writeBytes(*buffer) }
        override fun writeByteData(register: Int, value: Byte) =
            channelSelector { device.writeByteData(register, value) }

        override fun writeWordData(register: Int, value: Short) =
            channelSelector { device.writeWordData(register, value) }

        override fun writeI2CBlockData(register: Int, vararg buffer: Byte) =
            channelSelector { device.writeI2CBlockData(register, *buffer) }

        override fun processCall(register: Int, value: Short): Short =
            channelSelector { device.processCall(register, value) }

        override fun readWrite(vararg commands: I2CDeviceInterface.Command?) =
            channelSelector { device.readWrite(*commands) }

        override fun readWrite(messages: Array<out I2CDeviceInterface.I2CMessage>?, buffer: ByteArray?) =
            channelSelector { device.readWrite(messages, buffer) }

        override fun readWrite(registerWriteFlags: Int, vararg commands: I2CDeviceInterface.Command?) =
            channelSelector { device.readWrite(registerWriteFlags, *commands) }

        override fun readNoStop(registerAddress: Byte, rxData: ByteArray?, repeatedStart: Boolean): Int =
            channelSelector { device.readNoStop(registerAddress, rxData, repeatedStart) }

        override fun probe(mode: I2CDevice.ProbeMode?): Boolean = channelSelector { device.probe(mode) }
        override fun writeQuick(bit: Byte) = channelSelector { device.writeQuick(bit) }
        override fun readBlockData(register: Int): ByteArray = channelSelector { device.readBlockData(register) }
        override fun writeBlockData(register: Int, vararg data: Byte) =
            channelSelector { device.writeBlockData(register, *data) }

        override fun blockProcessCall(register: Int, vararg txData: Byte): ByteArray =
            channelSelector { device.blockProcessCall(register, *txData) }
    }

    companion object {
        const val DEFAULT_I2C_DEVICE = 0x70
    }
}
