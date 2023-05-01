//[kobots-devices](../../../index.md)/[crackers.kobots.utilities](../index.md)/[PointerGauge](index.md)/[PointerGauge](-pointer-gauge.md)

# PointerGauge

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

constructor(image: [Image](https://docs.oracle.com/javase/8/docs/api/java/awt/Image.html), minimumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, maximumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, shape: [PointerGauge.Shape](-shape/index.md) = Shape.SEMICIRCLE, foreground: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.WHITE, background: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.BLACK, font: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = Font.SANS_SERIF, fontColor: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = foreground)

Alternate constructor: uses the image to derive the graphics and dimensions.

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

constructor(graphics: [Graphics2D](https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html), width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), minimumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, maximumValue: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 100.0, label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, shape: [PointerGauge.Shape](-shape/index.md) = Shape.SEMICIRCLE, foreground: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.WHITE, background: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = Color.BLACK, font: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = Font.SANS_SERIF, fontColor: [Color](https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html) = foreground)
