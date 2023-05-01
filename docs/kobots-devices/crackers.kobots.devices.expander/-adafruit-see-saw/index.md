//[kobots-devices](../../../index.md)/[crackers.kobots.devices.expander](../index.md)/[AdafruitSeeSaw](index.md)

# AdafruitSeeSaw

open class [AdafruitSeeSaw](index.md)(i2CDevice: I2CDevice, val initReset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : DeviceInterface

An I2C to whatever helper chip. Note that this chip does **not** use &quot;normal&quot; I2C registers, but rather selects &quot;registry&quot; locations with write before read.

Based on the Adafruit [CircuitPython library](https://github.com/adafruit/Adafruit_CircuitPython_seesaw) and the [Arduino library](https://github.com/adafruit/Adafruit_Seesaw)

See [Using the SeeSaw](https://learn.adafruit.com/adafruit-seesaw-atsamd09-breakout?view=all#using-the-seesaw-platform)

The flow-control device is available, but typically not used.

#### Inheritors

| |
|---|
| [CRICKITHat](../-c-r-i-c-k-i-t-hat/index.md) |

## Constructors

| | |
|---|---|
| [AdafruitSeeSaw](-adafruit-see-saw.md) | [jvm]<br>constructor(i2CDevice: I2CDevice, initReset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [analogRead](analog-read.md) | [jvm]<br>fun [analogRead](analog-read.md)(pin: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Read value from [pin](analog-read.md) as an Int (to avoid any potential negative values). |
| [analogWrite](analog-write.md) | [jvm]<br>fun [analogWrite](analog-write.md)(pin: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), value: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), twoBytes: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)<br>Write value to [pin](analog-write.md) as a PWM value |
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [digitalRead](digital-read.md) | [jvm]<br>fun [digitalRead](digital-read.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Read an on/off value from a digital I/O port.<br>[jvm]<br>fun [digitalRead](digital-read.md)(ports: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt; |
| [digitalWrite](digital-write.md) | [jvm]<br>fun [digitalWrite](digital-write.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Write an on/off value to a digital I/O port. |
| [disableEncoderInterrupt](disable-encoder-interrupt.md) | [jvm]<br>fun [disableEncoderInterrupt](disable-encoder-interrupt.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [disableKeypadInterrupt](disable-keypad-interrupt.md) | [jvm]<br>fun [disableKeypadInterrupt](disable-keypad-interrupt.md)() |
| [disableSercomDataRdyInterrupt](disable-sercom-data-rdy-interrupt.md) | [jvm]<br>fun [disableSercomDataRdyInterrupt](disable-sercom-data-rdy-interrupt.md)(sercom: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0) |
| [EEPROMRead8](-e-e-p-r-o-m-read8.md) | [jvm]<br>fun [EEPROMRead8](-e-e-p-r-o-m-read8.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [EEPROMWrite](-e-e-p-r-o-m-write.md) | [jvm]<br>fun [EEPROMWrite](-e-e-p-r-o-m-write.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), buffer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), size: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [EEPROMWrite8](-e-e-p-r-o-m-write8.md) | [jvm]<br>fun [EEPROMWrite8](-e-e-p-r-o-m-write8.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), value: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [enableEncoderInterrupt](enable-encoder-interrupt.md) | [jvm]<br>fun [enableEncoderInterrupt](enable-encoder-interrupt.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [enableKeypadInterrupt](enable-keypad-interrupt.md) | [jvm]<br>fun [enableKeypadInterrupt](enable-keypad-interrupt.md)() |
| [enableSercomDataRdyInterrupt](enable-sercom-data-rdy-interrupt.md) | [jvm]<br>fun [enableSercomDataRdyInterrupt](enable-sercom-data-rdy-interrupt.md)(sercom: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0) |
| [getEncoderDelta](get-encoder-delta.md) | [jvm]<br>fun [getEncoderDelta](get-encoder-delta.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getEncoderPosition](get-encoder-position.md) | [jvm]<br>fun [getEncoderPosition](get-encoder-position.md)(encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getI2CAddr](get-i2-c-addr.md) | [jvm]<br>fun [getI2CAddr](get-i2-c-addr.md)(): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [getKeypadCount](get-keypad-count.md) | [jvm]<br>fun [getKeypadCount](get-keypad-count.md)(): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [getOptions](get-options.md) | [jvm]<br>fun [getOptions](get-options.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getProdDatecode](get-prod-datecode.md) | [jvm]<br>fun [getProdDatecode](get-prod-datecode.md)(pid: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), year: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), mon: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), day: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getTemp](get-temp.md) | [jvm]<br>fun [getTemp](get-temp.md)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getVersion](get-version.md) | [jvm]<br>fun [getVersion](get-version.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [pinMode](pin-mode.md) | [jvm]<br>fun [pinMode](pin-mode.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), mode: [AdafruitSeeSaw.Companion.SignalMode](-companion/-signal-mode/index.md)) |
| [readKeypad](read-keypad.md) | [jvm]<br>fun [readKeypad](read-keypad.md)(buffer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), count: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [readSercomData](read-sercom-data.md) | [jvm]<br>fun [readSercomData](read-sercom-data.md)(sercom: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [setEncoderPosition](set-encoder-position.md) | [jvm]<br>fun [setEncoderPosition](set-encoder-position.md)(pos: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), encoder: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) = 0) |
| [setGPIOInterrupts](set-g-p-i-o-interrupts.md) | [jvm]<br>fun [setGPIOInterrupts](set-g-p-i-o-interrupts.md)(pins: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), enabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setI2CAddr](set-i2-c-addr.md) | [jvm]<br>fun [setI2CAddr](set-i2-c-addr.md)(addr: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |
| [setKeypadEvent](set-keypad-event.md) | [jvm]<br>fun [setKeypadEvent](set-keypad-event.md)(key: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), edge: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), enable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |
| [setPWMFreq](set-p-w-m-freq.md) | [jvm]<br>fun [setPWMFreq](set-p-w-m-freq.md)(pin: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), freq: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html))<br>Setting the PWM frequency goes hand-in-hand with the [analogWrite](analog-write.md) function (same pins). Together, these values set the basic pulsed output from the PWM pins on the device. |
| [softwareReset](software-reset.md) | [jvm]<br>fun [softwareReset](software-reset.md)(delay: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html) = Duration.ofMillis(500)) |
| [touchRead](touch-read.md) | [jvm]<br>fun [touchRead](touch-read.md)(pin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [UARTSetBaud](-u-a-r-t-set-baud.md) | [jvm]<br>fun [UARTSetBaud](-u-a-r-t-set-baud.md)(baud: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [analogInputPins](analog-input-pins.md) | [jvm]<br>lateinit var [analogInputPins](analog-input-pins.md): [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)<br>Analog pin inputs. This must be set for [analogRead](analog-read.md) to work. |
| [chipId](chip-id.md) | [jvm]<br>val [chipId](chip-id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [initReset](init-reset.md) | [jvm]<br>val [initReset](init-reset.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [pwmOutputPins](pwm-output-pins.md) | [jvm]<br>lateinit var [pwmOutputPins](pwm-output-pins.md): [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)<br>Analog PWM (servo) pin outputs. This must be set for [analogWrite](analog-write.md) to work. |
