//[kobots-devices](../../../index.md)/[crackers.kobots.devices.display](../index.md)/[LcdProgressBar](index.md)

# LcdProgressBar

[jvm]\
class [LcdProgressBar](index.md)(lcd: LcdInterface&lt;*&gt;, displayRow: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, leftToRight: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)

Creates a &quot;progress bar&quot; that occupies one line of an LCD. The default line is `0`, or the top-most.

The bar uses `|`,`||`, `|||` and `|||!` custom characters (effectively) to fill each character cell. The bar may be shown either left-to-right (default) or right-to-left.

## Constructors

| | |
|---|---|
| [LcdProgressBar](-lcd-progress-bar.md) | [jvm]<br>constructor(lcd: LcdInterface&lt;*&gt;, displayRow: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, leftToRight: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [jvm]<br>var [value](value.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
