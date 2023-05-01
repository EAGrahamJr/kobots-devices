//[kobots-devices](../../index.md)/[crackers.kobots.devices.display](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [GrayOled](-gray-oled/index.md) | [jvm]<br>abstract class [GrayOled](-gray-oled/index.md)(delegate: SsdOledCommunicationChannel, val width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val displayType: [GrayOled.DisplayType](-gray-oled/-display-type/index.md), initializationSequence: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html) = IntArray(0), reset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : DeviceInterface<br>Abstract B/W display. |
| [HD44780Lcd](-h-d44780-lcd/index.md) | [jvm]<br>object [HD44780Lcd](-h-d44780-lcd/index.md)<br>Pre-defined LCD objects. Closes the back-pack when the display is closed. |
| [LcdProgressBar](-lcd-progress-bar/index.md) | [jvm]<br>class [LcdProgressBar](-lcd-progress-bar/index.md)(lcd: LcdInterface&lt;*&gt;, displayRow: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, leftToRight: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)<br>Creates a &quot;progress bar&quot; that occupies one line of an LCD. The default line is `0`, or the top-most. |
| [SSD1327](-s-s-d1327/index.md) | [jvm]<br>class [SSD1327](-s-s-d1327/index.md)(delegate: SsdOledCommunicationChannel) : [GrayOled](-gray-oled/index.md)<br>https://learn.adafruit.com/adafruit-grayscale-1-5-128x128-oled-display?view=all |
