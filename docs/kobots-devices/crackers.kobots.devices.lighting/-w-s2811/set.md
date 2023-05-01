//[kobots-devices](../../../index.md)/[crackers.kobots.devices.lighting](../index.md)/[WS2811](index.md)/[set](set.md)

# set

[jvm]\
abstract operator fun [set](set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](-pixel-color/index.md))

Set an individual pixel (this is available as an *indexed* value). If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.

[jvm]\
open operator fun [set](set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))

open operator fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))

[jvm]\
abstract operator fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](-pixel-color/index.md))

Set a range of pixels to a color. If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.

[jvm]\
abstract operator fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), colors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WS2811.PixelColor](-pixel-color/index.md)&gt;)

Set a range of pixels to a range of colors. The color list must be equal to or larger than the range specified. If [autoWrite](auto-write.md) is enabled, the results are * immediately uploaded.
