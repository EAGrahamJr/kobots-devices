//[kobots-devices](../../../index.md)/[crackers.kobots.devices.expander](../index.md)/[CRICKITHat](index.md)

# CRICKITHat

[jvm]\
class [CRICKITHat](index.md)(i2CDevice: I2CDevice = defaultI2CDevice, val initReset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : [AdafruitSeeSaw](../-adafruit-see-saw/index.md)

CRICKIT Hat pin definitions for the SeeSaw device.

## Constructors

| | |
|---|---|
| [CRICKITHat](-c-r-i-c-k-i-t-hat.md) | [jvm]<br>constructor(i2CDevice: I2CDevice = defaultI2CDevice, initReset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [analogRead](../-adafruit-see-saw/analog-read.md) | [jvm]<br>fun [analogRead](../-adafruit-see-saw/analog-read.md)(pin: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Read value from [pin](../-adafruit-see-saw/analog-read.md) as an Int (to avoid any potential negative values). |
| [analogWrite](../-adafruit-see-saw/analog-write.md) | [jvm]<br>fun [analogWrite](../-adafruit-see-saw/analog-write.md)(pin: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), value: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), twoBytes: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)<br>Write value to [pin](../-adafruit-see-saw/analog-write.md) as a PWM value |
| [close](../-adafruit-see-saw/close.md) | [jvm]<br>open override fun [close](../-adafruit-see-saw/close.md)() |
| [digitalRead](../-adafruit-see-saw/digital-read.md) | [jvm]<br>fun [digitalRead](../-adafruit-see-saw/digital-read.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Read an on/off value from a digital I/O port.<br>[jvm]<br>fun [digitalRead](../-adafruit-see-saw/digital-read.md)(ports: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt; |
| [digitalWrite](../-adafruit-see-saw/digital-write.md) | [jvm]<br>fun [digitalWrite](../-adafruit-see-saw/digital-write.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Write an on/off value to a digital I/O port. |
| [disableEncoderInterrupt](../-adafruit-see-saw/disable-encoder-interrupt.md) | [jvm]<br>fun [disableEncoderInterrupt](../-adafruit-see-saw/disable-encoder-interrupt.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [disableKeypadInterrupt](../-adafruit-see-saw/disable-keypad-interrupt.md) | [jvm]<br>fun [disableKeypadInterrupt](../-adafruit-see-saw/disable-keypad-interrupt.md)() |
| [disableSercomDataRdyInterrupt](../-adafruit-see-saw/disable-sercom-data-rdy-interrupt.md) | [jvm]<br>fun [disableSercomDataRdyInterrupt](../-adafruit-see-saw/disable-sercom-data-rdy-interrupt.md)(sercom: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0) |
| [EEPROMRead8](../-adafruit-see-saw/-e-e-p-r-o-m-read8.md) | [jvm]<br>fun [EEPROMRead8](../-adafruit-see-saw/-e-e-p-r-o-m-read8.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [EEPROMWrite](../-adafruit-see-saw/-e-e-p-r-o-m-write.md) | [jvm]<br>fun [EEPROMWrite](../-adafruit-see-saw/-e-e-p-r-o-m-write.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), buffer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), size: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [EEPROMWrite8](../-adafruit-see-saw/-e-e-p-r-o-m-write8.md) | [jvm]<br>fun [EEPROMWrite8](../-adafruit-see-saw/-e-e-p-r-o-m-write8.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), value: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [enableEncoderInterrupt](../-adafruit-see-saw/enable-encoder-interrupt.md) | [jvm]<br>fun [enableEncoderInterrupt](../-adafruit-see-saw/enable-encoder-interrupt.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [enableKeypadInterrupt](../-adafruit-see-saw/enable-keypad-interrupt.md) | [jvm]<br>fun [enableKeypadInterrupt](../-adafruit-see-saw/enable-keypad-interrupt.md)() |
| [enableSercomDataRdyInterrupt](../-adafruit-see-saw/enable-sercom-data-rdy-interrupt.md) | [jvm]<br>fun [enableSercomDataRdyInterrupt](../-adafruit-see-saw/enable-sercom-data-rdy-interrupt.md)(sercom: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0) |
| [getEncoderDelta](../-adafruit-see-saw/get-encoder-delta.md) | [jvm]<br>fun [getEncoderDelta](../-adafruit-see-saw/get-encoder-delta.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getEncoderPosition](../-adafruit-see-saw/get-encoder-position.md) | [jvm]<br>fun [getEncoderPosition](../-adafruit-see-saw/get-encoder-position.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getI2CAddr](../-adafruit-see-saw/get-i2-c-addr.md) | [jvm]<br>fun [getI2CAddr](../-adafruit-see-saw/get-i2-c-addr.md)(): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [getKeypadCount](../-adafruit-see-saw/get-keypad-count.md) | [jvm]<br>fun [getKeypadCount](../-adafruit-see-saw/get-keypad-count.md)(): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [getOptions](../-adafruit-see-saw/get-options.md) | [jvm]<br>fun [getOptions](../-adafruit-see-saw/get-options.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getProdDatecode](../-adafruit-see-saw/get-prod-datecode.md) | [jvm]<br>fun [getProdDatecode](../-adafruit-see-saw/get-prod-datecode.md)(pid: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), year: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), mon: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), day: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getTemp](../-adafruit-see-saw/get-temp.md) | [jvm]<br>fun [getTemp](../-adafruit-see-saw/get-temp.md)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getVersion](../-adafruit-see-saw/get-version.md) | [jvm]<br>fun [getVersion](../-adafruit-see-saw/get-version.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [pinMode](../-adafruit-see-saw/pin-mode.md) | [jvm]<br>fun [pinMode](../-adafruit-see-saw/pin-mode.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), mode: [AdafruitSeeSaw.Companion.SignalMode](../-adafruit-see-saw/-companion/-signal-mode/index.md)) |
| [readKeypad](../-adafruit-see-saw/read-keypad.md) | [jvm]<br>fun [readKeypad](../-adafruit-see-saw/read-keypad.md)(buffer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), count: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [readSercomData](../-adafruit-see-saw/read-sercom-data.md) | [jvm]<br>fun [readSercomData](../-adafruit-see-saw/read-sercom-data.md)(sercom: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [setEncoderPosition](../-adafruit-see-saw/set-encoder-position.md) | [jvm]<br>fun [setEncoderPosition](../-adafruit-see-saw/set-encoder-position.md)(pos: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0) |
| [setGPIOInterrupts](../-adafruit-see-saw/set-g-p-i-o-interrupts.md) | [jvm]<br>fun [setGPIOInterrupts](../-adafruit-see-saw/set-g-p-i-o-interrupts.md)(pins: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), enabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setI2CAddr](../-adafruit-see-saw/set-i2-c-addr.md) | [jvm]<br>fun [setI2CAddr](../-adafruit-see-saw/set-i2-c-addr.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [setKeypadEvent](../-adafruit-see-saw/set-keypad-event.md) | [jvm]<br>fun [setKeypadEvent](../-adafruit-see-saw/set-keypad-event.md)(key: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), edge: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), enable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |
| [setPWMFreq](../-adafruit-see-saw/set-p-w-m-freq.md) | [jvm]<br>fun [setPWMFreq](../-adafruit-see-saw/set-p-w-m-freq.md)(pin: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), freq: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html))<br>Setting the PWM frequency goes hand-in-hand with the [analogWrite](../-adafruit-see-saw/analog-write.md) function (same pins). Together, these values set the basic pulsed output from the PWM pins on the device. |
| [softwareReset](../-adafruit-see-saw/software-reset.md) | [jvm]<br>fun [softwareReset](../-adafruit-see-saw/software-reset.md)(delay: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html) = Duration.ofMillis(500)) |
| [touchRead](../-adafruit-see-saw/touch-read.md) | [jvm]<br>fun [touchRead](../-adafruit-see-saw/touch-read.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [UARTSetBaud](../-adafruit-see-saw/-u-a-r-t-set-baud.md) | [jvm]<br>fun [UARTSetBaud](../-adafruit-see-saw/-u-a-r-t-set-baud.md)(baud: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [analogInputPins](../-adafruit-see-saw/analog-input-pins.md) | [jvm]<br>lateinit var [analogInputPins](../-adafruit-see-saw/analog-input-pins.md): [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)<br>Analog pin inputs. This must be set for [analogRead](../-adafruit-see-saw/analog-read.md) to work. |
| [chipId](../-adafruit-see-saw/chip-id.md) | [jvm]<br>val [chipId](../-adafruit-see-saw/chip-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [initReset](../-adafruit-see-saw/init-reset.md) | [jvm]<br>val [initReset](../-adafruit-see-saw/init-reset.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [pwmOutputPins](../-adafruit-see-saw/pwm-output-pins.md) | [jvm]<br>lateinit var [pwmOutputPins](../-adafruit-see-saw/pwm-output-pins.md): [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)<br>Analog PWM (servo) pin outputs. This must be set for [analogWrite](../-adafruit-see-saw/analog-write.md) to work. |
