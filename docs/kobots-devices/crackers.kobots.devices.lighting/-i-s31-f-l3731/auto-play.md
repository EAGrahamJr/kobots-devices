//[kobots-devices](../../../index.md)/[crackers.kobots.devices.lighting](../index.md)/[IS31FL3731](index.md)/[autoPlay](auto-play.md)

# autoPlay

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

fun [autoPlay](auto-play.md)(delay: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, loops: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, frames: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)

Start &quot;autoplay&quot; (rotate through) the number of [frames](auto-play.md) (default all), with a limited number of [loops](auto-play.md) (default `0`=infinite) and an approximate [delay](auto-play.md) in milliseconds.

**NOTE** the delay must be less than `704` due to register limitations. Values <`11` are effectively `0`.
