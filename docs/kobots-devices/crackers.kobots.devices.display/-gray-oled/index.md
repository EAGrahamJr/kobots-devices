//[kobots-devices](../../../index.md)/[crackers.kobots.devices.display](../index.md)/[GrayOled](index.md)

# GrayOled

abstract class [GrayOled](index.md)(delegate: SsdOledCommunicationChannel, val width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val displayType: [GrayOled.DisplayType](-display-type/index.md), initializationSequence: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html) = IntArray(0), reset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : DeviceInterface

Abstract B/W display.

TODO Both C++ and Python use an in-memory buffer and only write to the display when that &quot;region&quot; is dirty TODO Because Java has a separate image construct, is this necessary?

#### Inheritors

| |
|---|
| [SSD1327](../-s-s-d1327/index.md) |

## Constructors

| | |
|---|---|
| [GrayOled](-gray-oled.md) | [jvm]<br>constructor(delegate: SsdOledCommunicationChannel, width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), displayType: [GrayOled.DisplayType](-display-type/index.md), initializationSequence: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html) = IntArray(0), reset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [DisplayType](-display-type/index.md) | [jvm]<br>enum [DisplayType](-display-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[GrayOled.DisplayType](-display-type/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [appendBuffer](append-buffer.md) | [jvm]<br>fun [appendBuffer](append-buffer.md)(bytes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;) |
| [clear](clear.md) | [jvm]<br>fun [clear](clear.md)()<br>Basically displays a black rectangle, with optional dimensions. |
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [display](display.md) | [jvm]<br>fun [display](display.md)(image: [BufferedImage](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html)): [BufferedImage](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html)<br>Display an image. This is the preferred method? |
| [getNativeImageType](get-native-image-type.md) | [jvm]<br>open fun [getNativeImageType](get-native-image-type.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [invertDisplay](invert-display.md) | [jvm]<br>abstract fun [invertDisplay](invert-display.md)(invert: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [show](show.md) | [jvm]<br>fun [show](show.md)() |

## Properties

| Name | Summary |
|---|---|
| [displayOn](display-on.md) | [jvm]<br>abstract var [displayOn](display-on.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [displayType](display-type.md) | [jvm]<br>val [displayType](display-type.md): [GrayOled.DisplayType](-display-type/index.md) |
| [height](height.md) | [jvm]<br>val [height](height.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [width](width.md) | [jvm]<br>val [width](width.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
