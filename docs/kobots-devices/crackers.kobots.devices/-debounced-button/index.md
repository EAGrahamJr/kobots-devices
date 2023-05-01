//[kobots-devices](../../../index.md)/[crackers.kobots.devices](../index.md)/[DebouncedButton](index.md)

# DebouncedButton

[jvm]\
class [DebouncedButton](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(gpio: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), debounceTime: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html), pud: GpioPullUpDown = GpioPullUpDown.NONE, activeHigh: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = pud != GpioPullUpDown.PULL_UP, deviceFactory: GpioDeviceFactoryInterface = nativeDeviceFactory) : DebouncedDigitalInputDevice

Simple extension to get the `whenPressed` and `whenReleased` semantics with debounce.

## Constructors

| | |
|---|---|
| [DebouncedButton](-debounced-button.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(gpio: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), debounceTime: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html), pud: GpioPullUpDown = GpioPullUpDown.NONE, activeHigh: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = pud != GpioPullUpDown.PULL_UP, deviceFactory: GpioDeviceFactoryInterface = nativeDeviceFactory) |

## Functions

| Name | Summary |
|---|---|
| [accept](index.md#-244338900%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [accept](index.md#-244338900%2FFunctions%2F-1216412040)(p0: DigitalInputEvent) |
| [addListener](index.md#-928465486%2FFunctions%2F-1216412040) | [jvm]<br>open fun [addListener](index.md#-928465486%2FFunctions%2F-1216412040)(p0: DeviceEventConsumer&lt;DigitalInputEvent&gt;) |
| [andThen](index.md#47068618%2FFunctions%2F-1216412040) | [jvm]<br>open fun [andThen](index.md#47068618%2FFunctions%2F-1216412040)(p0: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)&lt;in DigitalInputEvent&gt;): [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)&lt;DigitalInputEvent&gt; |
| [changeDetection](index.md#48985362%2FFunctions%2F-1216412040) | [jvm]<br>open fun [changeDetection](index.md#48985362%2FFunctions%2F-1216412040)() |
| [close](index.md#-416476753%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [close](index.md#-416476753%2FFunctions%2F-1216412040)() |
| [getGpio](index.md#-1378245852%2FFunctions%2F-1216412040) | [jvm]<br>open fun [getGpio](index.md#-1378245852%2FFunctions%2F-1216412040)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getName](index.md#1681722309%2FFunctions%2F-1216412040) | [jvm]<br>open fun [getName](index.md#1681722309%2FFunctions%2F-1216412040)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getPullUpDown](index.md#1411953518%2FFunctions%2F-1216412040) | [jvm]<br>open fun [getPullUpDown](index.md#1411953518%2FFunctions%2F-1216412040)(): GpioPullUpDown |
| [getValue](index.md#276982169%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [getValue](index.md#276982169%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasListeners](index.md#-842626500%2FFunctions%2F-1216412040) | [jvm]<br>open fun [hasListeners](index.md#-842626500%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isActive](index.md#-721018332%2FFunctions%2F-1216412040) | [jvm]<br>open fun [isActive](index.md#-721018332%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isActiveHigh](index.md#1579502436%2FFunctions%2F-1216412040) | [jvm]<br>open fun [isActiveHigh](index.md#1579502436%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeAllListeners](index.md#952499807%2FFunctions%2F-1216412040) | [jvm]<br>open fun [removeAllListeners](index.md#952499807%2FFunctions%2F-1216412040)() |
| [removeListener](index.md#2025367501%2FFunctions%2F-1216412040) | [jvm]<br>open fun [removeListener](index.md#2025367501%2FFunctions%2F-1216412040)(p0: DeviceEventConsumer&lt;DigitalInputEvent&gt;) |
| [waitForActive](index.md#1535893226%2FFunctions%2F-1216412040) | [jvm]<br>open fun [waitForActive](index.md#1535893226%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>open fun [waitForActive](index.md#-721437688%2FFunctions%2F-1216412040)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [waitForInactive](index.md#-1918411675%2FFunctions%2F-1216412040) | [jvm]<br>open fun [waitForInactive](index.md#-1918411675%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>open fun [waitForInactive](index.md#-1769677885%2FFunctions%2F-1216412040)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [waitForValue](index.md#-308349569%2FFunctions%2F-1216412040) | [jvm]<br>open fun [waitForValue](index.md#-308349569%2FFunctions%2F-1216412040)(p0: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [whenActivated](index.md#231844653%2FFunctions%2F-1216412040) | [jvm]<br>open fun [whenActivated](index.md#231844653%2FFunctions%2F-1216412040)(p0: [LongConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html)) |
| [whenDeactivated](index.md#-1600275700%2FFunctions%2F-1216412040) | [jvm]<br>open fun [whenDeactivated](index.md#-1600275700%2FFunctions%2F-1216412040)(p0: [LongConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html)) |
| [whenPressed](when-pressed.md) | [jvm]<br>fun [whenPressed](when-pressed.md)(buttonConsumer: [LongConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html))<br>Action to perform when the button is pressed. |
| [whenReleased](when-released.md) | [jvm]<br>fun [whenReleased](when-released.md)(buttonConsumer: [LongConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html))<br>Action to perform when the button is released. |

## Properties

| Name | Summary |
|---|---|
| [trigger](index.md#1380664558%2FProperties%2F-1216412040) | [jvm]<br>val [trigger](index.md#1380664558%2FProperties%2F-1216412040): GpioEventTrigger |
