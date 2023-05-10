//[kobots-devices](../../index.md)/[crackers.kobots.devices](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AnodeRgbPwmLed](-anode-rgb-pwm-led/index.md) | [jvm]<br>class [AnodeRgbPwmLed](-anode-rgb-pwm-led/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(redPin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), greenPin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), bluePin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), deviceFactory: PwmOutputDeviceFactoryInterface = nativeDeviceFactory) : DeviceInterface<br>RGB LED with common anode - this is **inverted** from RgbPwmLed. Provides the same interface. |
| [DebouncedButton](-debounced-button/index.md) | [jvm]<br>class [DebouncedButton](-debounced-button/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(gpio: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), debounceTime: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html), pud: GpioPullUpDown = GpioPullUpDown.NONE, activeHigh: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = pud != GpioPullUpDown.PULL_UP, deviceFactory: GpioDeviceFactoryInterface = nativeDeviceFactory) : DebouncedDigitalInputDevice<br>Simple extension to get the `whenPressed` and `whenReleased` semantics with debounce. |
| [I2CSubRegister](-i2-c-sub-register/index.md) | [jvm]<br>interface [I2CSubRegister](-i2-c-sub-register/index.md)&lt;[N](-i2-c-sub-register/index.md) : [Number](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)&gt;<br>Creates a read/write sub-register (e.g. bit-mapped values). The values read/write are based on a bit-mask - e.g. this will extract and write only a *subset* of a register value. This is for those occasions that an I2C register contains multiple values. |
| [Quadruple](-quadruple/index.md) | [jvm]<br>data class [Quadruple](-quadruple/index.md)&lt;out [A](-quadruple/index.md), out [B](-quadruple/index.md), out [C](-quadruple/index.md), out [D](-quadruple/index.md)&gt;(val first: [A](-quadruple/index.md), val second: [B](-quadruple/index.md), val third: [C](-quadruple/index.md), val fourth: [D](-quadruple/index.md)) : [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)<br>Four things. |

## Functions

| Name | Summary |
|---|---|
| [asDegreesF](as-degrees-f.md) | [jvm]<br>fun [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html).[asDegreesF](as-degrees-f.md)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Convert a float representing degrees C to F. |
| [at](at.md) | [jvm]<br>infix fun ServoDevice.[at](at.md)(angle: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))<br>Sets the [angle](at.md) for the servo. Note that this **must** be in the range the servo supports.<br>[jvm]<br>infix fun ServoDevice.[at](at.md)(angle: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>[jvm]<br>infix fun MotorInterface.[at](at.md)(speed: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))<br>Run a motor at this relative speed (-1 to 1). |
| [inRange](in-range.md) | [jvm]<br>fun [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html).[inRange](in-range.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), range: [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Checks to see if an Int is in the specified range |
| [plusAssign](plus-assign.md) | [jvm]<br>operator fun LcdInterface&lt;*&gt;.[plusAssign](plus-assign.md)(char: [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html))<br>Add [char](plus-assign.md) at current location<br>[jvm]<br>operator fun LcdInterface&lt;*&gt;.[plusAssign](plus-assign.md)(special: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Add a [special](plus-assign.md) code at current location<br>[jvm]<br>operator fun LcdInterface&lt;*&gt;.[plusAssign](plus-assign.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Add [text](plus-assign.md) at current location |
| [position](position.md) | [jvm]<br>infix fun LcdInterface&lt;*&gt;.[position](position.md)(location: [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;)<br>Use a Pair to express row, column |
| [rotate](rotate.md) | [jvm]<br>fun StepperMotorInterface.[rotate](rotate.md)(degrees: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), direction: StepperMotorInterface.Direction = Direction.FORWARD, pause: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html) = Duration.ofMillis(5), interruptus: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { false })<br>Rotate with a simple interruption - note this **can** be bad if the interruption method is left as the default. |
| [set](set.md) | [jvm]<br>infix fun DigitalOutputDevice.[set](set.md)(input: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>infix fun PwmOutputDevice.[set](set.md)(sensorValue: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))<br>infix fun ServoDevice.[set](set.md)(input: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>[jvm]<br>infix fun PwmOutputDevice.[set](set.md)(sensorValue: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Adds DSL-like capabilities to `diozero`<br>[jvm]<br>infix fun ServoDevice.[set](set.md)(input: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))<br>Sets the value for the servo (-1 to 1).<br>[jvm]<br>operator fun LcdInterface&lt;*&gt;.[set](set.md)(row: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Uses array notion to set [text](set.md) on a [row](set.md) |
| [setAngle](set-angle.md) | [jvm]<br>fun ServoDevice.[setAngle](set-angle.md)(input: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [shortSubRegister](short-sub-register.md) | [jvm]<br>fun I2CDevice.[shortSubRegister](short-sub-register.md)(register: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), mask: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [I2CSubRegister](-i2-c-sub-register/index.md)&lt;[Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)&gt;<br>Read and write from 16-bit registers (short) using a mask to extract/write values. |
| [to2Bytes](to2-bytes.md) | [jvm]<br>fun [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html).[to2Bytes](to2-bytes.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)&gt;<br>Convert to two bytes |
| [toBytes](to-bytes.md) | [jvm]<br>fun [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html).[toBytes](to-bytes.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)&gt;<br>Convert to two bytes |
| [toInt](to-int.md) | [jvm]<br>fun [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html).[toInt](to-int.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Convert a boolean to integer &quot;equivalent&quot; |
| [twoBytesAndBuffer](two-bytes-and-buffer.md) | [jvm]<br>fun [twoBytesAndBuffer](two-bytes-and-buffer.md)(first: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), second: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), buffer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>Common I2C pattern: two bytes and a buffer (register, offset, payload) |

## Properties

| Name | Summary |
|---|---|
| [qwiicKill](qwiic-kill.md) | [jvm]<br>val [qwiicKill](qwiic-kill.md): [DebouncedButton](-debounced-button/index.md)<br>Kill button on enabled Qwiic pHAT v2.0 (https://www.sparkfun.com/products/15945). The default consumer exits the application with code 3. (Included here because Qwiic is I2C) |