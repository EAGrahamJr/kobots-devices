//[kobots-devices](../../../../index.md)/[crackers.kobots.devices.expander](../../index.md)/[AdafruitSeeSaw](../index.md)/[Companion](index.md)

# Companion

[jvm]\
object [Companion](index.md)

## Types

| Name | Summary |
|---|---|
| [DeviceType](-device-type/index.md) | [jvm]<br>enum [DeviceType](-device-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[AdafruitSeeSaw.Companion.DeviceType](-device-type/index.md)&gt; |
| [SignalMode](-signal-mode/index.md) | [jvm]<br>enum [SignalMode](-signal-mode/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[AdafruitSeeSaw.Companion.SignalMode](-signal-mode/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [ADC_BASE](-a-d-c_-b-a-s-e.md) | [jvm]<br>const val [ADC_BASE](-a-d-c_-b-a-s-e.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [ADC_CHANNEL_OFFSET](-a-d-c_-c-h-a-n-n-e-l_-o-f-f-s-e-t.md) | [jvm]<br>const val [ADC_CHANNEL_OFFSET](-a-d-c_-c-h-a-n-n-e-l_-o-f-f-s-e-t.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [ADC_INTEN](-a-d-c_-i-n-t-e-n.md) | [jvm]<br>const val [ADC_INTEN](-a-d-c_-i-n-t-e-n.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 2 |
| [ADC_INTENCLR](-a-d-c_-i-n-t-e-n-c-l-r.md) | [jvm]<br>const val [ADC_INTENCLR](-a-d-c_-i-n-t-e-n-c-l-r.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3 |
| [ADC_STATUS](-a-d-c_-s-t-a-t-u-s.md) | [jvm]<br>const val [ADC_STATUS](-a-d-c_-s-t-a-t-u-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [ADC_WINMODE](-a-d-c_-w-i-n-m-o-d-e.md) | [jvm]<br>const val [ADC_WINMODE](-a-d-c_-w-i-n-m-o-d-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 4 |
| [ADC_WINTHRESH](-a-d-c_-w-i-n-t-h-r-e-s-h.md) | [jvm]<br>const val [ADC_WINTHRESH](-a-d-c_-w-i-n-t-h-r-e-s-h.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 5 |
| [DAC_BASE](-d-a-c_-b-a-s-e.md) | [jvm]<br>const val [DAC_BASE](-d-a-c_-b-a-s-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 10 |
| [DAP_BASE](-d-a-p_-b-a-s-e.md) | [jvm]<br>const val [DAP_BASE](-d-a-p_-b-a-s-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 12 |
| [EEPROM_BASE](-e-e-p-r-o-m_-b-a-s-e.md) | [jvm]<br>const val [EEPROM_BASE](-e-e-p-r-o-m_-b-a-s-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 13 |
| [EEPROM_I2C_ADDR](-e-e-p-r-o-m_-i2-c_-a-d-d-r.md) | [jvm]<br>const val [EEPROM_I2C_ADDR](-e-e-p-r-o-m_-i2-c_-a-d-d-r.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 63 |
| [ENCODER_BASE](-e-n-c-o-d-e-r_-b-a-s-e.md) | [jvm]<br>const val [ENCODER_BASE](-e-n-c-o-d-e-r_-b-a-s-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 17 |
| [ENCODER_DELTA](-e-n-c-o-d-e-r_-d-e-l-t-a.md) | [jvm]<br>const val [ENCODER_DELTA](-e-n-c-o-d-e-r_-d-e-l-t-a.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 64 |
| [ENCODER_INTENCLR](-e-n-c-o-d-e-r_-i-n-t-e-n-c-l-r.md) | [jvm]<br>const val [ENCODER_INTENCLR](-e-n-c-o-d-e-r_-i-n-t-e-n-c-l-r.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 32 |
| [ENCODER_INTENSET](-e-n-c-o-d-e-r_-i-n-t-e-n-s-e-t.md) | [jvm]<br>const val [ENCODER_INTENSET](-e-n-c-o-d-e-r_-i-n-t-e-n-s-e-t.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 16 |
| [ENCODER_POSITION](-e-n-c-o-d-e-r_-p-o-s-i-t-i-o-n.md) | [jvm]<br>const val [ENCODER_POSITION](-e-n-c-o-d-e-r_-p-o-s-i-t-i-o-n.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 48 |
| [ENCODER_STATUS](-e-n-c-o-d-e-r_-s-t-a-t-u-s.md) | [jvm]<br>const val [ENCODER_STATUS](-e-n-c-o-d-e-r_-s-t-a-t-u-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [GPIO_BASE](-g-p-i-o_-b-a-s-e.md) | [jvm]<br>const val [GPIO_BASE](-g-p-i-o_-b-a-s-e.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [GPIO_BULK](-g-p-i-o_-b-u-l-k.md) | [jvm]<br>const val [GPIO_BULK](-g-p-i-o_-b-u-l-k.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [GPIO_BULK_CLEAR](-g-p-i-o_-b-u-l-k_-c-l-e-a-r.md) | [jvm]<br>const val [GPIO_BULK_CLEAR](-g-p-i-o_-b-u-l-k_-c-l-e-a-r.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [GPIO_BULK_SET](-g-p-i-o_-b-u-l-k_-s-e-t.md) | [jvm]<br>const val [GPIO_BULK_SET](-g-p-i-o_-b-u-l-k_-s-e-t.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [GPIO_BULK_TOGGLE](-g-p-i-o_-b-u-l-k_-t-o-g-g-l-e.md) | [jvm]<br>const val [GPIO_BULK_TOGGLE](-g-p-i-o_-b-u-l-k_-t-o-g-g-l-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 7 |
| [GPIO_DIRECTION_INPUT](-g-p-i-o_-d-i-r-e-c-t-i-o-n_-i-n-p-u-t.md) | [jvm]<br>const val [GPIO_DIRECTION_INPUT](-g-p-i-o_-d-i-r-e-c-t-i-o-n_-i-n-p-u-t.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [GPIO_DIRECTION_OUTPUT](-g-p-i-o_-d-i-r-e-c-t-i-o-n_-o-u-t-p-u-t.md) | [jvm]<br>const val [GPIO_DIRECTION_OUTPUT](-g-p-i-o_-d-i-r-e-c-t-i-o-n_-o-u-t-p-u-t.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [GPIO_INTENCLR](-g-p-i-o_-i-n-t-e-n-c-l-r.md) | [jvm]<br>const val [GPIO_INTENCLR](-g-p-i-o_-i-n-t-e-n-c-l-r.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 9 |
| [GPIO_INTENSET](-g-p-i-o_-i-n-t-e-n-s-e-t.md) | [jvm]<br>const val [GPIO_INTENSET](-g-p-i-o_-i-n-t-e-n-s-e-t.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 8 |
| [GPIO_INTFLAG](-g-p-i-o_-i-n-t-f-l-a-g.md) | [jvm]<br>const val [GPIO_INTFLAG](-g-p-i-o_-i-n-t-f-l-a-g.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 10 |
| [GPIO_PULL_RESISTOR_DISABLED](-g-p-i-o_-p-u-l-l_-r-e-s-i-s-t-o-r_-d-i-s-a-b-l-e-d.md) | [jvm]<br>const val [GPIO_PULL_RESISTOR_DISABLED](-g-p-i-o_-p-u-l-l_-r-e-s-i-s-t-o-r_-d-i-s-a-b-l-e-d.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [GPIO_PULL_RESISTOR_ENABLED](-g-p-i-o_-p-u-l-l_-r-e-s-i-s-t-o-r_-e-n-a-b-l-e-d.md) | [jvm]<br>const val [GPIO_PULL_RESISTOR_ENABLED](-g-p-i-o_-p-u-l-l_-r-e-s-i-s-t-o-r_-e-n-a-b-l-e-d.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [INTERRUPT_BASE](-i-n-t-e-r-r-u-p-t_-b-a-s-e.md) | [jvm]<br>const val [INTERRUPT_BASE](-i-n-t-e-r-r-u-p-t_-b-a-s-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 11 |
| [NEOPIXEL_BASE](-n-e-o-p-i-x-e-l_-b-a-s-e.md) | [jvm]<br>const val [NEOPIXEL_BASE](-n-e-o-p-i-x-e-l_-b-a-s-e.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [NEOPIXEL_BUF](-n-e-o-p-i-x-e-l_-b-u-f.md) | [jvm]<br>const val [NEOPIXEL_BUF](-n-e-o-p-i-x-e-l_-b-u-f.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [NEOPIXEL_BUF_LENGTH](-n-e-o-p-i-x-e-l_-b-u-f_-l-e-n-g-t-h.md) | [jvm]<br>const val [NEOPIXEL_BUF_LENGTH](-n-e-o-p-i-x-e-l_-b-u-f_-l-e-n-g-t-h.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [NEOPIXEL_PIN](-n-e-o-p-i-x-e-l_-p-i-n.md) | [jvm]<br>const val [NEOPIXEL_PIN](-n-e-o-p-i-x-e-l_-p-i-n.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [NEOPIXEL_SHOW](-n-e-o-p-i-x-e-l_-s-h-o-w.md) | [jvm]<br>const val [NEOPIXEL_SHOW](-n-e-o-p-i-x-e-l_-s-h-o-w.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [NEOPIXEL_SPEED](-n-e-o-p-i-x-e-l_-s-p-e-e-d.md) | [jvm]<br>const val [NEOPIXEL_SPEED](-n-e-o-p-i-x-e-l_-s-p-e-e-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 2 |
| [NEOPIXEL_STATUS](-n-e-o-p-i-x-e-l_-s-t-a-t-u-s.md) | [jvm]<br>const val [NEOPIXEL_STATUS](-n-e-o-p-i-x-e-l_-s-t-a-t-u-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [SERCOM0_BASE](-s-e-r-c-o-m0_-b-a-s-e.md) | [jvm]<br>const val [SERCOM0_BASE](-s-e-r-c-o-m0_-b-a-s-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 2 |
| [SERCOM_BAUD](-s-e-r-c-o-m_-b-a-u-d.md) | [jvm]<br>const val [SERCOM_BAUD](-s-e-r-c-o-m_-b-a-u-d.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 4 |
| [SERCOM_DATA](-s-e-r-c-o-m_-d-a-t-a.md) | [jvm]<br>const val [SERCOM_DATA](-s-e-r-c-o-m_-d-a-t-a.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 5 |
| [SERCOM_INTEN](-s-e-r-c-o-m_-i-n-t-e-n.md) | [jvm]<br>const val [SERCOM_INTEN](-s-e-r-c-o-m_-i-n-t-e-n.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 2 |
| [SERCOM_INTENCLR](-s-e-r-c-o-m_-i-n-t-e-n-c-l-r.md) | [jvm]<br>const val [SERCOM_INTENCLR](-s-e-r-c-o-m_-i-n-t-e-n-c-l-r.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3 |
| [SERCOM_STATUS](-s-e-r-c-o-m_-s-t-a-t-u-s.md) | [jvm]<br>const val [SERCOM_STATUS](-s-e-r-c-o-m_-s-t-a-t-u-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [STATUS_BASE](-s-t-a-t-u-s_-b-a-s-e.md) | [jvm]<br>const val [STATUS_BASE](-s-t-a-t-u-s_-b-a-s-e.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [STATUS_HW_ID](-s-t-a-t-u-s_-h-w_-i-d.md) | [jvm]<br>const val [STATUS_HW_ID](-s-t-a-t-u-s_-h-w_-i-d.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [STATUS_OPTIONS](-s-t-a-t-u-s_-o-p-t-i-o-n-s.md) | [jvm]<br>const val [STATUS_OPTIONS](-s-t-a-t-u-s_-o-p-t-i-o-n-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3 |
| [STATUS_SWRST](-s-t-a-t-u-s_-s-w-r-s-t.md) | [jvm]<br>const val [STATUS_SWRST](-s-t-a-t-u-s_-s-w-r-s-t.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [STATUS_TEMP](-s-t-a-t-u-s_-t-e-m-p.md) | [jvm]<br>const val [STATUS_TEMP](-s-t-a-t-u-s_-t-e-m-p.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [STATUS_VERSION](-s-t-a-t-u-s_-v-e-r-s-i-o-n.md) | [jvm]<br>const val [STATUS_VERSION](-s-t-a-t-u-s_-v-e-r-s-i-o-n.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [TIMER_BASE](-t-i-m-e-r_-b-a-s-e.md) | [jvm]<br>const val [TIMER_BASE](-t-i-m-e-r_-b-a-s-e.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [TIMER_FREQ](-t-i-m-e-r_-f-r-e-q.md) | [jvm]<br>const val [TIMER_FREQ](-t-i-m-e-r_-f-r-e-q.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [TIMER_PWM](-t-i-m-e-r_-p-w-m.md) | [jvm]<br>const val [TIMER_PWM](-t-i-m-e-r_-p-w-m.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [TIMER_STATUS](-t-i-m-e-r_-s-t-a-t-u-s.md) | [jvm]<br>const val [TIMER_STATUS](-t-i-m-e-r_-s-t-a-t-u-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [TOUCH_BASE](-t-o-u-c-h_-b-a-s-e.md) | [jvm]<br>const val [TOUCH_BASE](-t-o-u-c-h_-b-a-s-e.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [TOUCH_CHANNEL_OFFSET](-t-o-u-c-h_-c-h-a-n-n-e-l_-o-f-f-s-e-t.md) | [jvm]<br>const val [TOUCH_CHANNEL_OFFSET](-t-o-u-c-h_-c-h-a-n-n-e-l_-o-f-f-s-e-t.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
