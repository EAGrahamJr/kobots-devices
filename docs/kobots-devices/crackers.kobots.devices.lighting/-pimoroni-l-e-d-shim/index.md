//[kobots-devices](../../../index.md)/[crackers.kobots.devices.lighting](../index.md)/[PimoroniLEDShim](index.md)

# PimoroniLEDShim

[jvm]\
class [PimoroniLEDShim](index.md)(shimDevice: I2CDevice = DEFAULT_SHIM_DEVICE) : [IS31FL3731](../-i-s31-f-l3731/index.md)

## Constructors

| | |
|---|---|
| [PimoroniLEDShim](-pimoroni-l-e-d-shim.md) | [jvm]<br>constructor(shimDevice: I2CDevice = DEFAULT_SHIM_DEVICE) |

## Functions

| Name | Summary |
|---|---|
| [autoPlay](../-i-s31-f-l3731/auto-play.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [autoPlay](../-i-s31-f-l3731/auto-play.md)(delay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, loops: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, frames: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)<br>Start &quot;autoplay&quot; (rotate through) the number of [frames](../-i-s31-f-l3731/auto-play.md) (default all), with a limited number of [loops](../-i-s31-f-l3731/auto-play.md) (default `0`=infinite) and an approximate [delay](../-i-s31-f-l3731/auto-play.md) in milliseconds. |
| [close](../-i-s31-f-l3731/close.md) | [jvm]<br>open override fun [close](../-i-s31-f-l3731/close.md)() |
| [fill](../-i-s31-f-l3731/fill.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [fill](../-i-s31-f-l3731/fill.md)(brightness: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), blink: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, frame: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = getFrame())<br>Fills the entire display with a *white* color at the indicated [brightness](../-i-s31-f-l3731/fill.md) percentage (1 to 100) and selected [frame](../-i-s31-f-l3731/fill.md). |
| [getBlink](../-i-s31-f-l3731/get-blink.md) | [jvm]<br>fun [getBlink](../-i-s31-f-l3731/get-blink.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getFrame](../-i-s31-f-l3731/get-frame.md) | [jvm]<br>fun [getFrame](../-i-s31-f-l3731/get-frame.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [pixelAddress](pixel-address.md) | [jvm]<br>open override fun [pixelAddress](pixel-address.md)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), y: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Someone else already did all the math... |
| [pixelColor](pixel-color.md) | [jvm]<br>fun [pixelColor](pixel-color.md)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html), frame: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = getFrame()) |
| [pixelRGB](pixel-r-g-b.md) | [jvm]<br>fun [pixelRGB](pixel-r-g-b.md)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), r: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), g: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), b: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), frame: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = getFrame()) |
| [reset](../-i-s31-f-l3731/reset.md) | [jvm]<br>fun [reset](../-i-s31-f-l3731/reset.md)() |
| [set](set.md) | [jvm]<br>operator fun [set](set.md)(x: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [setAll](set-all.md) | [jvm]<br>infix fun [setAll](set-all.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [setBlink](../-i-s31-f-l3731/set-blink.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [setBlink](../-i-s31-f-l3731/set-blink.md)(rate: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)<br>Set and enable blink. [rate](../-i-s31-f-l3731/set-blink.md) in milliseconds is a multiple of `270` up to `1890`, or `0` to disable. |
| [setFrame](../-i-s31-f-l3731/set-frame.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [setFrame](../-i-s31-f-l3731/set-frame.md)(f: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), show: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Set the current default frame, optionally [show](../-i-s31-f-l3731/set-frame.md)ing it. |
| [showFrame](../-i-s31-f-l3731/show-frame.md) | [jvm]<br>fun [showFrame](../-i-s31-f-l3731/show-frame.md)(f: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Specifically show a frame - does *not* set the current default frame. |
| [sleep](../-i-s31-f-l3731/sleep.md) | [jvm]<br>fun [sleep](../-i-s31-f-l3731/sleep.md)(goToSleep: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [height](height.md) | [jvm]<br>open override val [height](height.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3 |
| [width](width.md) | [jvm]<br>open override val [width](width.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 28 |
