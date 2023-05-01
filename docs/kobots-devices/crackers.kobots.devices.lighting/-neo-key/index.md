//[kobots-devices](../../../index.md)/[crackers.kobots.devices.lighting](../index.md)/[NeoKey](index.md)

# NeoKey

[jvm]\
class [NeoKey](index.md)(i2CDevice: I2CDevice = DEFAULT_I2C) : DeviceInterface, [WS2811](../-w-s2811/index.md)

Adafruit https://www.adafruit.com/product/4980

## Constructors

| | |
|---|---|
| [NeoKey](-neo-key.md) | [jvm]<br>constructor(i2CDevice: I2CDevice = DEFAULT_I2C) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [color](color.md) | [jvm]<br>infix fun [color](color.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md)<br>Get the color of this key. |
| [colors](colors.md) | [jvm]<br>fun [colors](colors.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WS2811.PixelColor](../-w-s2811/-pixel-color/index.md)&gt;<br>All the colors |
| [fill](fill.md) | [jvm]<br>open override fun [fill](fill.md)(color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>Fill the entire device with this color. If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open fun [fill](../-w-s2811/fill.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>Fill the entire device with this color. If [autoWrite](../-w-s2811/auto-write.md) is enabled, the results are immediately uploaded. |
| [get](get.md) | [jvm]<br>operator fun [get](get.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Get a button value. |
| [off](../-w-s2811/off.md) | [jvm]<br>open fun [off](../-w-s2811/off.md)()<br>Shorthand for `fill(Color.BLACK)` |
| [plus](../-w-s2811/plus.md) | [jvm]<br>open operator fun [plus](../-w-s2811/plus.md)(color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>open operator fun [plus](../-w-s2811/plus.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [read](read.md) | [jvm]<br>fun [read](read.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;<br>Read all the switches |
| [set](set.md) | [jvm]<br>open operator override fun [set](set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>Set an individual pixel (this is available as an *indexed* value). If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open operator override fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>Set a range of pixels to a color. If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open operator override fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), colors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WS2811.PixelColor](../-w-s2811/-pixel-color/index.md)&gt;)<br>Set a range of pixels to a range of colors. The color list must be equal to or larger than the range specified. If [autoWrite](auto-write.md) is enabled, the results are * immediately uploaded.<br>[jvm]<br>open operator fun [set](../-w-s2811/set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>open operator fun [set](../-w-s2811/set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |

## Properties

| Name | Summary |
|---|---|
| [autoWrite](auto-write.md) | [jvm]<br>open override var [autoWrite](auto-write.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [brightness](brightness.md) | [jvm]<br>open override var [brightness](brightness.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [pixels](pixels.md) | [jvm]<br>val [pixels](pixels.md): [CRICKITNeoPixel](../../crackers.kobots.devices.expander/-c-r-i-c-k-i-t-neo-pixel/index.md) |
