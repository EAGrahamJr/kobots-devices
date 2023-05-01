//[kobots-devices](../../../index.md)/[crackers.kobots.devices.expander](../index.md)/[CRICKITNeoPixel](index.md)

# CRICKITNeoPixel

[jvm]\
class [CRICKITNeoPixel](index.md) : [PixelBuf](../../crackers.kobots.devices.lighting/-pixel-buf/index.md)

NeoPixel handling via the SeeSaw

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [fill](../../crackers.kobots.devices.lighting/-pixel-buf/fill.md) | [jvm]<br>open override fun [fill](../../crackers.kobots.devices.lighting/-pixel-buf/fill.md)(color: [WS2811.PixelColor](../../crackers.kobots.devices.lighting/-w-s2811/-pixel-color/index.md))<br>Fill the entire device with this color. If [autoWrite](../../crackers.kobots.devices.lighting/-pixel-buf/auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open fun [fill](../../crackers.kobots.devices.lighting/-w-s2811/fill.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>Fill the entire device with this color. If [autoWrite](../../crackers.kobots.devices.lighting/-w-s2811/auto-write.md) is enabled, the results are immediately uploaded. |
| [get](../../crackers.kobots.devices.lighting/-pixel-buf/get.md) | [jvm]<br>operator fun [get](../../crackers.kobots.devices.lighting/-pixel-buf/get.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [WS2811.PixelColor](../../crackers.kobots.devices.lighting/-w-s2811/-pixel-color/index.md)<br>Current color for the given pixel. |
| [iterator](../../crackers.kobots.devices.lighting/-pixel-buf/iterator.md) | [jvm]<br>operator fun [iterator](../../crackers.kobots.devices.lighting/-pixel-buf/iterator.md)(): [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)&lt;[WS2811.PixelColor](../../crackers.kobots.devices.lighting/-w-s2811/-pixel-color/index.md)&gt;<br>Immutable operator - changing these colors has no effect. |
| [off](../../crackers.kobots.devices.lighting/-w-s2811/off.md) | [jvm]<br>open fun [off](../../crackers.kobots.devices.lighting/-w-s2811/off.md)()<br>Shorthand for `fill(Color.BLACK)` |
| [plus](../../crackers.kobots.devices.lighting/-w-s2811/plus.md) | [jvm]<br>open operator fun [plus](../../crackers.kobots.devices.lighting/-w-s2811/plus.md)(color: [WS2811.PixelColor](../../crackers.kobots.devices.lighting/-w-s2811/-pixel-color/index.md))<br>open operator fun [plus](../../crackers.kobots.devices.lighting/-w-s2811/plus.md)(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [set](../../crackers.kobots.devices.lighting/-pixel-buf/set.md) | [jvm]<br>open operator override fun [set](../../crackers.kobots.devices.lighting/-pixel-buf/set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](../../crackers.kobots.devices.lighting/-w-s2811/-pixel-color/index.md))<br>Set an individual pixel (this is available as an *indexed* value). If [autoWrite](../../crackers.kobots.devices.lighting/-pixel-buf/auto-write.md) is enabled, the results are immediately uploaded.<br>[jvm]<br>open operator override fun [set](../../crackers.kobots.devices.lighting/-pixel-buf/set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [WS2811.PixelColor](../../crackers.kobots.devices.lighting/-w-s2811/-pixel-color/index.md))<br>Set a range of pixels to a color. If [autoWrite](../../crackers.kobots.devices.lighting/-pixel-buf/auto-write.md) is enabled, the results are * immediately uploaded.<br>[jvm]<br>open operator override fun [set](../../crackers.kobots.devices.lighting/-pixel-buf/set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), colors: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[WS2811.PixelColor](../../crackers.kobots.devices.lighting/-w-s2811/-pixel-color/index.md)&gt;)<br>Set a range of pixels to a range of colors. The color list must be equal to or larger than the range specified. If [autoWrite](../../crackers.kobots.devices.lighting/-pixel-buf/auto-write.md) is enabled, the results are * immediately uploaded.<br>[jvm]<br>open operator fun [set](../../crackers.kobots.devices.lighting/-w-s2811/set.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html))<br>open operator fun [set](../../crackers.kobots.devices.lighting/-w-s2811/set.md)(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), end: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html)) |
| [show](../../crackers.kobots.devices.lighting/-pixel-buf/show.md) | [jvm]<br>fun [show](../../crackers.kobots.devices.lighting/-pixel-buf/show.md)()<br>Sends the current pixel buffer to the device. |

## Properties

| Name | Summary |
|---|---|
| [autoWrite](../../crackers.kobots.devices.lighting/-pixel-buf/auto-write.md) | [jvm]<br>open override var [autoWrite](../../crackers.kobots.devices.lighting/-pixel-buf/auto-write.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [brightness](../../crackers.kobots.devices.lighting/-pixel-buf/brightness.md) | [jvm]<br>open override var [brightness](../../crackers.kobots.devices.lighting/-pixel-buf/brightness.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [byteOrder](../../crackers.kobots.devices.lighting/-pixel-buf/byte-order.md) | [jvm]<br>val [byteOrder](../../crackers.kobots.devices.lighting/-pixel-buf/byte-order.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [size](../../crackers.kobots.devices.lighting/-pixel-buf/size.md) | [jvm]<br>val [size](../../crackers.kobots.devices.lighting/-pixel-buf/size.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
