//[kobots-devices](../../index.md)/[crackers.kobots.devices](index.md)/[set](set.md)

# set

[jvm]\
infix fun PwmOutputDevice.[set](set.md)(sensorValue: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

Adds DSL-like capabilities to `diozero`

[jvm]\
infix fun PwmOutputDevice.[set](set.md)(sensorValue: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))

infix fun DigitalOutputDevice.[set](set.md)(input: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

infix fun ServoDevice.[set](set.md)(input: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

[jvm]\
infix fun ServoDevice.[set](set.md)(input: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))

Sets the value for the servo (-1 to 1).

[jvm]\
operator fun LcdInterface&lt;*&gt;.[set](set.md)(row: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Uses array notion to set [text](set.md) on a [row](set.md)

Example: `lcd[2] = "Hello, World"`
