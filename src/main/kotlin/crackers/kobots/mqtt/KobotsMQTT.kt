package crackers.kobots.mqtt

import org.eclipse.paho.mqttv5.client.*
import org.eclipse.paho.mqttv5.common.MqttException
import org.eclipse.paho.mqttv5.common.MqttMessage
import org.eclipse.paho.mqttv5.common.MqttSubscription
import org.eclipse.paho.mqttv5.common.packet.MqttProperties
import org.slf4j.LoggerFactory
import java.time.Duration
import java.time.LocalTime
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * MQTT wrapper for Kobots.
 *
 * Because this is still in the experimental phase, QoS is **always** `0` and each session starts "clean" (clients do not
 * retain "state"). Auto-reconnect is enabled and any subscriptions are re-subscribed on re-connect.
 */
class KobotsMQTT(private val clientName: String, broker: String = BROKER, persistence: MqttClientPersistence? = null) :
    AutoCloseable {
    private val logger = LoggerFactory.getLogger("${clientName}MQTT")
    private val subscribers = mutableMapOf<String, List<(String) -> Unit>>()

    private val mqttClient by lazy {
        val options = MqttConnectionOptions().apply {
            isAutomaticReconnect = true
            isCleanStart = true
            keepAliveInterval = 10
            connectionTimeout = 10
        }
        MqttAsyncClient(broker, clientName, persistence).apply {
            setCallback(mqttCallback)
            connect(options).waitForCompletion()
        }
    }

    private val mqttCallback = object : MqttCallback {
        override fun disconnected(disconnectResponse: MqttDisconnectResponse) {
            logger.error("Disconnected: $disconnectResponse")
        }

        override fun mqttErrorOccurred(exception: MqttException) {
            logger.error("Error: $exception")
        }

        override fun connectComplete(reconnect: Boolean, serverURI: String?) {
            if (reconnect) {
                logger.error("Re-connected")
                subscribers.forEach { topic, subscribers ->
                    logger.warn("Re-subscribing to $topic")
                    subscribers.forEach { subscribe(topic, it) }
                }
            } else {
                logger.warn("Connected")
            }
        }

        override fun authPacketArrived(reasonCode: Int, properties: MqttProperties?) {
            // don't care?
        }

        override fun messageArrived(topic: String, message: MqttMessage) {
            // just use the listener
        }

        override fun deliveryComplete(token: IMqttToken?) {
            // don't care?
        }
    }

    private val executor by lazy { Executors.newSingleThreadScheduledExecutor() }
    fun startAliveCheck(intervalSeconds: Long = 60) {
        executor.scheduleAtFixedRate(
            { mqttClient.publish(KOBOTS_ALIVE, clientName.toByteArray(), 0, false) },
            intervalSeconds,
            intervalSeconds,
            TimeUnit.SECONDS
        )
    }

    private val lastCheckIn = mutableMapOf<String, LocalTime>()
    fun handleAliveCheck(listener: (String) -> Unit, deadIntervalSeconds: Long = 120) {
        // store everybody's last time
        subscribe(KOBOTS_ALIVE) { s: String -> lastCheckIn[s] = LocalTime.now() }

        // check for dead kobots
        val runner = Runnable {
            val now = LocalTime.now()
            lastCheckIn.forEach { (host, lastSeenAt) ->
                if (Duration.between(lastSeenAt, now).seconds > deadIntervalSeconds) {
                    logger.error("$host last seen $lastSeenAt")
                    listener(host)
                }
            }
        }
        executor.scheduleAtFixedRate(runner, deadIntervalSeconds / 2, deadIntervalSeconds / 2, TimeUnit.SECONDS)
    }

    fun subscribe(topic: String, listener: (String) -> Unit) {
        // assume the users of this will only call it once
        subscribers.compute(topic) { _, list ->
            if (list == null) {
                listOf(listener)
            } else {
                list + listener
            }
        }

        val sub = MqttSubscription(topic, 0)
        // STUPID FUCKING BUG!!!!
        val props = MqttProperties().apply {
            subscriptionIdentifiers = listOf(0)
        }
        val wrapper = IMqttMessageListener { _, message ->
            try {
                listener(message.payload.decodeToString())
            } catch (t: Throwable) {
                logger.error("Subscriber error", t)
            }
        }
        mqttClient.subscribe(arrayOf(sub), null, null, wrapper, props).waitForCompletion()
    }

    fun publish(topic: String, payload: String) {
        mqttClient.publish(topic, MqttMessage(payload.toByteArray())).waitForCompletion()
    }

    override fun close() {
        mqttClient.close()
    }

    companion object {
        /**
         * The alive-check topic used by Kobots.
         */
        const val KOBOTS_ALIVE = "kobots/alive"

        /**
         * Default broker.
         */
        const val BROKER = "tcp://192.168.1.4:1883"
    }
}
