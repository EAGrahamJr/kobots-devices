//[kobots-devices](../../../index.md)/[crackers.kobots.devices.display](../index.md)/[SSD1327](index.md)

# SSD1327

[jvm]\
class [SSD1327](index.md)(delegate: SsdOledCommunicationChannel) : [GrayOled](../-gray-oled/index.md)

https://learn.adafruit.com/adafruit-grayscale-1-5-128x128-oled-display?view=all

- 
   Arduino
- 
   https://github.com/adafruit/Adafruit_SSD1327
- 
   https://github.com/adafruit/Adafruit-GFX-Library

Python - https://github.com/adafruit/Adafruit_CircuitPython_SSD1327

Check out https://github.com/OmniXRI/Pi_Pico_OLED_SSD1327_I2C

## Constructors

| | |
|---|---|
| [SSD1327](-s-s-d1327.md) | [jvm]<br>constructor(delegate: SsdOledCommunicationChannel) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [appendBuffer](../-gray-oled/append-buffer.md) | [jvm]<br>fun [appendBuffer](../-gray-oled/append-buffer.md)(bytes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;) |
| [clear](../-gray-oled/clear.md) | [jvm]<br>fun [clear](../-gray-oled/clear.md)()<br>Basically displays a black rectangle, with optional dimensions. |
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [display](../-gray-oled/display.md) | [jvm]<br>fun [display](../-gray-oled/display.md)(image: [BufferedImage](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html)): [BufferedImage](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html)<br>Display an image. This is the preferred method? |
| [getNativeImageType](../-gray-oled/get-native-image-type.md) | [jvm]<br>open fun [getNativeImageType](../-gray-oled/get-native-image-type.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [invertDisplay](invert-display.md) | [jvm]<br>open override fun [invertDisplay](invert-display.md)(invert: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [show](../-gray-oled/show.md) | [jvm]<br>fun [show](../-gray-oled/show.md)() |

## Properties

| Name | Summary |
|---|---|
| [displayOn](display-on.md) | [jvm]<br>open override var [displayOn](display-on.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [displayType](../-gray-oled/display-type.md) | [jvm]<br>val [displayType](../-gray-oled/display-type.md): [GrayOled.DisplayType](../-gray-oled/-display-type/index.md) |
| [height](../-gray-oled/height.md) | [jvm]<br>val [height](../-gray-oled/height.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [width](../-gray-oled/width.md) | [jvm]<br>val [width](../-gray-oled/width.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
