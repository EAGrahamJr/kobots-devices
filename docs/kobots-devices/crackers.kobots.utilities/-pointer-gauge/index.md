//[kobots-devices](../../../index.md)/[crackers.kobots.utilities](../index.md)/[PointerGauge](index.md)

# PointerGauge

[jvm]\
class [PointerGauge](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(graphics: [Graphics2D](https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html), width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), minimumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, maximumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 100.0, label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, shape: [PointerGauge.Shape](-shape/index.md) = Shape.SEMICIRCLE, foreground: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.WHITE, background: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.BLACK, font: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = Font.SANS_SERIF, fontColor: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = foreground)

A very simple circular- or arc-style &quot;gauge&quot; (e.g. &quot;dial&quot;, &quot;dial pointer&quot;), without resorting to large libraries.

##  Specifying the drawing space

- 
   graphics = the canvas to draw on
- 
   width, height = the drawing area size

or

- 
   image = a *rendered* image

##  Graph values

- 
   minimumValue, maximumValue = range of expected values: the pointer won't go beyond these (default **0-100**)
- 
   label = optional label in the center of the dial
- 
   shape = either [Shape.SEMICIRCLE](-shape/-s-e-m-i-c-i-r-c-l-e/index.md) (default) or [Shape.CIRCLE](-shape/-c-i-r-c-l-e/index.md)
- 
   foreground = color for the dial, ticks, and pointer (default `Color.WHITE`)
- 
   background = color of the middle of the dial (default `Color.BLACK`)
- 
   font = name of the font to use for the tick labels and the optional dial label (default &quot;SansSerif&quot;)
- 
   fontColor = color for said font (defaults to `foreground`)

## Constructors

| | |
|---|---|
| [PointerGauge](-pointer-gauge.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(image: [Image](https://docs.oracle.com/javase/8/docs/api/java/awt/Image.html), minimumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, maximumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, shape: [PointerGauge.Shape](-shape/index.md) = Shape.SEMICIRCLE, foreground: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.WHITE, background: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.BLACK, font: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = Font.SANS_SERIF, fontColor: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = foreground)<br>Alternate constructor: uses the image to derive the graphics and dimensions.<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(graphics: [Graphics2D](https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html), width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), minimumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, maximumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 100.0, label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, shape: [PointerGauge.Shape](-shape/index.md) = Shape.SEMICIRCLE, foreground: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.WHITE, background: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.BLACK, font: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = Font.SANS_SERIF, fontColor: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = foreground) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [Shape](-shape/index.md) | [jvm]<br>enum [Shape](-shape/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[PointerGauge.Shape](-shape/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [paint](paint.md) | [jvm]<br>fun [paint](paint.md)()<br>Render the gauge. |
| [setValue](set-value.md) | [jvm]<br>fun [setValue](set-value.md)(value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))<br>Set the current value to display |
