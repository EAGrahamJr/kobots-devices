//[kobots-devices](../../../index.md)/[crackers.kobots.devices](../index.md)/[AnodeRgbPwmLed](index.md)

# AnodeRgbPwmLed

[jvm]\
class [AnodeRgbPwmLed](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(redPin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), greenPin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), bluePin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), deviceFactory: PwmOutputDeviceFactoryInterface = nativeDeviceFactory) : DeviceInterface

RGB LED with common anode - this is **inverted** from RgbPwmLed. Provides the same interface.

Basically, the LED pins are initially *high* and when the anode is **high**, the light is *off*.

## Constructors

| | |
|---|---|
| [AnodeRgbPwmLed](-anode-rgb-pwm-led.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(redPin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), greenPin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), bluePin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), deviceFactory: PwmOutputDeviceFactoryInterface = nativeDeviceFactory) |

## Functions

| Name | Summary |
|---|---|
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [getValues](get-values.md) | [jvm]<br>fun [getValues](get-values.md)(): [FloatArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html)<br>Get the value of all LEDs. |
| [off](off.md) | [jvm]<br>fun [off](off.md)()<br>Turn all LEDs off. |
| [on](on.md) | [jvm]<br>fun [on](on.md)()<br>Turn all LEDs on. |
| [setColor](set-color.md) | [jvm]<br>fun [setColor](set-color.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>Sets the [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) of all the LEDs. |
| [setValues](set-values.md) | [jvm]<br>fun [setValues](set-values.md)(red: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), green: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), blue: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))<br>Set the value of all LEDs. |
| [toggle](toggle.md) | [jvm]<br>fun [toggle](toggle.md)()<br>Toggle the state of all LEDs. |
