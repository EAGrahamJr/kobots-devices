//[kobots-devices](../../../index.md)/[crackers.kobots.devices.lighting](../index.md)/[IS31FL3731](index.md)

# IS31FL3731

abstract class [IS31FL3731](index.md)(i2CDevice: I2CDevice = DEFAULT_DEVICE, frames: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt; = (0..7)) : DeviceInterface

Represents an IS31LF3731 charlieplex IC. All pixel operations are **direct write** to the device, no buffering. The display has (by default) 8 addressable &quot;frames&quot; (memory buffers) that contain the display information.

Some base methods are protected so that the individual users of this chip can adjust inputs based on the device.

Additional information from the [docs](https://www.lumissil.com/assets/pdf/core/IS31FL3731_DS.pdf)

#### Inheritors

| |
|---|
| [PimoroniLEDShim](../-pimoroni-l-e-d-shim/index.md) |

## Constructors

| | |
|---|---|
| [IS31FL3731](-i-s31-f-l3731.md) | [jvm]<br>constructor(i2CDevice: I2CDevice = DEFAULT_DEVICE, frames: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt; = (0..7)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [autoPlay](auto-play.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [autoPlay](auto-play.md)(delay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, loops: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, frames: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)<br>Start &quot;autoplay&quot; (rotate through) the number of [frames](auto-play.md) (default all), with a limited number of [loops](auto-play.md) (default `0`=infinite) and an approximate [delay](auto-play.md) in milliseconds. |
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [fill](fill.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [fill](fill.md)(brightness: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), blink: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, frame: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = getFrame())<br>Fills the entire display with a *white* color at the indicated [brightness](fill.md) percentage (1 to 100) and selected [frame](fill.md). |
| [getBlink](get-blink.md) | [jvm]<br>fun [getBlink](get-blink.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getFrame](get-frame.md) | [jvm]<br>fun [getFrame](get-frame.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [pixelAddress](pixel-address.md) | [jvm]<br>open fun [pixelAddress](pixel-address.md)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), y: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [reset](reset.md) | [jvm]<br>fun [reset](reset.md)() |
| [setBlink](set-blink.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [setBlink](set-blink.md)(rate: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)<br>Set and enable blink. [rate](set-blink.md) in milliseconds is a multiple of `270` up to `1890`, or `0` to disable. |
| [setFrame](set-frame.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [setFrame](set-frame.md)(f: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), show: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Set the current default frame, optionally [show](set-frame.md)ing it. |
| [showFrame](show-frame.md) | [jvm]<br>fun [showFrame](show-frame.md)(f: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Specifically show a frame - does *not* set the current default frame. |
| [sleep](sleep.md) | [jvm]<br>fun [sleep](sleep.md)(goToSleep: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [height](height.md) | [jvm]<br>abstract val [height](height.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [width](width.md) | [jvm]<br>abstract val [width](width.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
