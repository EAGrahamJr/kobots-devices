//[kobots-devices](../../../index.md)/[crackers.kobots.devices](../index.md)/[DebouncedButton](index.md)/[DebouncedButton](-debounced-button.md)

# DebouncedButton

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)

constructor(gpio: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), debounceTime: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html), pud: GpioPullUpDown = GpioPullUpDown.NONE, activeHigh: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = pud != GpioPullUpDown.PULL_UP, deviceFactory: GpioDeviceFactoryInterface = nativeDeviceFactory)
