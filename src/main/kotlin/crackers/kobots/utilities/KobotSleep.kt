package crackers.kobots.utilities

import com.diozero.util.SleepUtil
import java.time.Duration

/**
 * Shortcuts for sleeping, wrapping the `diozero` utils.
 */
object KobotSleep {
    fun nanos(nanos: Long) {
        SleepUtil.busySleep(nanos)
    }

    fun micos(micros: Long) {
        duration(Duration.ofNanos(micros * 100))
    }

    fun millis(millis: Long) {
        duration(Duration.ofMillis(millis))
    }

    fun seconds(seconds: Long) {
        duration(Duration.ofSeconds(seconds))
    }

    fun duration(d: Duration) {
        nanos(d.toNanos())
    }

}
