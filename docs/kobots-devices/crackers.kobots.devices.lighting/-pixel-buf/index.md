//[kobots-devices](../../../index.md)/[crackers.kobots.devices.lighting](../index.md)/[PixelBuf](index.md)

# PixelBuf

abstract class [PixelBuf](index.md)(val size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val byteOrder: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;BGR&quot;, brightness: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) = 1.0f, autoWriteEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, header: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)? = null, trailer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)? = null) : [WS2811](../-w-s2811/index.md)

A set of one or more WS2811 addressable-LEDs.

A re-implementation of the &quot;pure Python&quot; Adafruit PixelBuf class, which is a re-implementation of the base Adafruit `pixelbuf` implementation.

Note that some difference exist: for example, this relies on the base Java classes to represent colors vs the Python `ColorUnion` construct that allows for 3 different types of &quot;colors&quot;.

TODO dotStar implementation is probably incorrect - needs device to test with

#### Inheritors

| |
|---|
| [CRICKITNeoPixel](../../crackers.kobots.devices.expander/-c-r-i-c-k-i-t-neo-pixel/index.md) |

## Constructors

| | |
|---|---|
| [PixelBuf](-pixel-buf.md) | [jvm]<br>constructor(size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), byteOrder: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;BGR&quot;, brightness: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) = 1.0f, autoWriteEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, header: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)? = null, trailer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)? = null) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [fill](fill.md) | [jvm]<br>open override fun [fill](fill.md)(color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>Fill the entire device with this color. If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open fun [fill](../-w-s2811/fill.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>Fill the entire device with this color. If [autoWrite](../-w-s2811/auto-write.md) is enabled, the results are immediately uploaded. |
| [get](get.md) | [jvm]<br>operator fun [get](get.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md)<br>Current color for the given pixel. |
| [iterator](iterator.md) | [jvm]<br>operator fun [iterator](iterator.md)(): [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)&lt;[WS2811.PixelColor](../-w-s2811/-pixel-color/index.md)&gt;<br>Immutable operator - changing these colors has no effect. |
| [off](../-w-s2811/off.md) | [jvm]<br>open fun [off](../-w-s2811/off.md)()<br>Shorthand for `fill(Color.BLACK)` |
| [plus](../-w-s2811/plus.md) | [jvm]<br>open operator fun [plus](../-w-s2811/plus.md)(color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>open operator fun [plus](../-w-s2811/plus.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [set](set.md) | [jvm]<br>open operator override fun [set](set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>Set an individual pixel (this is available as an *indexed* value). If [autoWrite](auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open operator override fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](../-w-s2811/-pixel-color/index.md))<br>Set a range of pixels to a color. If [autoWrite](auto-write.md) is enabled, the results are * immediately uploaded.<br>[jvm]<br>open operator override fun [set](set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), colors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WS2811.PixelColor](../-w-s2811/-pixel-color/index.md)&gt;)<br>Set a range of pixels to a range of colors. The color list must be equal to or larger than the range specified. If [autoWrite](auto-write.md) is enabled, the results are * immediately uploaded.<br>[jvm]<br>open operator fun [set](../-w-s2811/set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>open operator fun [set](../-w-s2811/set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [show](show.md) | [jvm]<br>fun [show](show.md)()<br>Sends the current pixel buffer to the device. |

## Properties

| Name | Summary |
|---|---|
| [autoWrite](auto-write.md) | [jvm]<br>open override var [autoWrite](auto-write.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [brightness](brightness.md) | [jvm]<br>open override var [brightness](brightness.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [byteOrder](byte-order.md) | [jvm]<br>val [byteOrder](byte-order.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [size](size.md) | [jvm]<br>val [size](size.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
