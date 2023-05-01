//[kobots-devices](../../../../index.md)/[crackers.kobots.devices.lighting](../../index.md)/[WS2811](../index.md)/[PixelColor](index.md)

# PixelColor

[jvm]\
class [PixelColor](index.md)(val color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html), val white: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val brightness: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)? = null) : [Cloneable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)

Wrapper for colors that includes an optional white level for devices that support that. An optional [brightness](brightness.md) can also be applied.

## Constructors

| | |
|---|---|
| [PixelColor](-pixel-color.md) | [jvm]<br>constructor(color: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html), white: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, brightness: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [clone](clone.md) | [jvm]<br>open override fun [clone](clone.md)(): [WS2811.PixelColor](index.md) |

## Properties

| Name | Summary |
|---|---|
| [brightness](brightness.md) | [jvm]<br>val [brightness](brightness.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)? = null |
| [color](color.md) | [jvm]<br>val [color](color.md): [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) |
| [white](white.md) | [jvm]<br>val [white](white.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
