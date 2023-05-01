//[kobots-devices](../../../index.md)/[crackers.kobots.devices.lighting](../index.md)/[WS2811](index.md)

# WS2811

interface [WS2811](index.md)

Defines [WS2811](https://cdn-shop.adafruit.com/datasheets/WS2811.pdf) aka **NeoPixels**.

#### Inheritors

| |
|---|
| [NeoKey](../-neo-key/index.md) |
| [PixelBuf](../-pixel-buf/index.md) |

## Types

| Name | Summary |
|---|---|
| [PixelColor](-pixel-color/index.md) | [jvm]<br>class [PixelColor](-pixel-color/index.md)(val color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html), val white: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val brightness: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)? = null) : [Cloneable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)<br>Wrapper for colors that includes an optional white level for devices that support that. An optional [brightness](-pixel-color/brightness.md) can also be applied. |

## Functions

| Name | Summary |
|---|---|
| [fill](fill.md) | [jvm]<br>abstract fun [fill](fill.md)(color: [WS2811.PixelColor](-pixel-color/index.md))<br>open fun [fill](fill.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>Fill the entire device with this color. If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded. |
| [off](off.md) | [jvm]<br>open fun [off](off.md)()<br>Shorthand for `fill(Color.BLACK)` |
| [plus](plus.md) | [jvm]<br>open operator fun [plus](plus.md)(color: [WS2811.PixelColor](-pixel-color/index.md))<br>open operator fun [plus](plus.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [set](set.md) | [jvm]<br>abstract operator fun [set](set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](-pixel-color/index.md))<br>Set an individual pixel (this is available as an *indexed* value). If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open operator fun [set](set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>open operator fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>[jvm]<br>abstract operator fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](-pixel-color/index.md))<br>Set a range of pixels to a color. If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>abstract operator fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), colors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WS2811.PixelColor](-pixel-color/index.md)&gt;)<br>Set a range of pixels to a range of colors. The color list must be equal to or larger than the range specified. If [autoWrite](auto-write.md) is enabled, the results are * immediately uploaded. |

## Properties

| Name | Summary |
|---|---|
| [autoWrite](auto-write.md) | [jvm]<br>abstract var [autoWrite](auto-write.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [brightness](brightness.md) | [jvm]<br>abstract var [brightness](brightness.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
