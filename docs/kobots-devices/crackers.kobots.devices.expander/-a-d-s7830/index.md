//[kobots-devices](../../../index.md)/[crackers.kobots.devices.expander](../index.md)/[ADS7830](index.md)

# ADS7830

[jvm]\
class [ADS7830](index.md)(val i2CDevice: I2CDevice = I2CDevice(1, DEFAULT_ADDRESS)) : AbstractDeviceFactory, AnalogInputDeviceFactoryInterface

The [ADS7830 ](https://cdn.datasheetspdf.com/pdf-down/A/D/S/ADS7830-etcTI.pdf) is a single-supply, low-power, 8-bit data acquisition device that features a serial I2C interface and an 8-channel multiplexer..

## Constructors

| | |
|---|---|
| [ADS7830](-a-d-s7830.md) | [jvm]<br>constructor(i2CDevice: I2CDevice = I2CDevice(1, DEFAULT_ADDRESS)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [close](index.md#-1131816083%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [close](index.md#-1131816083%2FFunctions%2F-1216412040)() |
| [createAnalogInputDevice](create-analog-input-device.md) | [jvm]<br>open override fun [createAnalogInputDevice](create-analog-input-device.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), pinInfo: PinInfo): AnalogInputDeviceInterface |
| [createI2CKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-727271957%2FFunctions%2F-1216412040) | [jvm]<br>override fun [createI2CKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-727271957%2FFunctions%2F-1216412040)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [createPinKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-903554259%2FFunctions%2F-1216412040) | [jvm]<br>override fun [createPinKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-903554259%2FFunctions%2F-1216412040)(p0: PinInfo): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [createPwmPinKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#227918347%2FFunctions%2F-1216412040) | [jvm]<br>override fun [createPwmPinKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#227918347%2FFunctions%2F-1216412040)(p0: PinInfo): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [createSerialKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#1330638766%2FFunctions%2F-1216412040) | [jvm]<br>override fun [createSerialKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#1330638766%2FFunctions%2F-1216412040)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [createServoPinKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#1462109854%2FFunctions%2F-1216412040) | [jvm]<br>override fun [createServoPinKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#1462109854%2FFunctions%2F-1216412040)(p0: PinInfo): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [createSpiKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-637756679%2FFunctions%2F-1216412040) | [jvm]<br>override fun [createSpiKey](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-637756679%2FFunctions%2F-1216412040)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [deviceClosed](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-2125226761%2FFunctions%2F-1216412040) | [jvm]<br>override fun [deviceClosed](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-2125226761%2FFunctions%2F-1216412040)(p0: InternalDeviceInterface) |
| [deviceOpened](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-390157670%2FFunctions%2F-1216412040) | [jvm]<br>override fun [deviceOpened](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-390157670%2FFunctions%2F-1216412040)(p0: InternalDeviceInterface) |
| [get](get.md) | [jvm]<br>operator fun [get](get.md)(channel: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Returns a scaled value (0.0 to 1.0) for the given channel. |
| [getBoardPinInfo](get-board-pin-info.md) | [jvm]<br>open override fun [getBoardPinInfo](get-board-pin-info.md)(): BoardPinInfo |
| [getDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-773896437%2FFunctions%2F-1216412040) | [jvm]<br>override fun &lt;[T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-773896437%2FFunctions%2F-1216412040) : InternalDeviceInterface&gt; [getDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-773896437%2FFunctions%2F-1216412040)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-773896437%2FFunctions%2F-1216412040) |
| [getName](get-name.md) | [jvm]<br>open override fun [getName](get-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getValue](get-value.md) | [jvm]<br>fun [~~getValue~~](get-value.md)(channel: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Returns a scaled value (0.0 to 1.0) for the given channel. |
| [isClosed](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-71276129%2FFunctions%2F-1216412040) | [jvm]<br>override fun [isClosed](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-71276129%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isDeviceOpened](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-7041288%2FFunctions%2F-1216412040) | [jvm]<br>override fun [isDeviceOpened](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-7041288%2FFunctions%2F-1216412040)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [provisionAnalogInputDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#1120721141%2FFunctions%2F-1216412040) | [jvm]<br>open fun [provisionAnalogInputDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#1120721141%2FFunctions%2F-1216412040)(p0: PinInfo): AnalogInputDeviceInterface |
| [readFromChannel](read-from-channel.md) | [jvm]<br>fun [readFromChannel](read-from-channel.md)(channel: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)<br>Read raw data from the [channel](read-from-channel.md) (0-7). |
| [registerDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#360839614%2FFunctions%2F-1216412040) | [jvm]<br>open fun &lt;[T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#360839614%2FFunctions%2F-1216412040) : InternalDeviceInterface&gt; [registerDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#360839614%2FFunctions%2F-1216412040)(p0: [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, p1: [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#360839614%2FFunctions%2F-1216412040)&gt;): [T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#360839614%2FFunctions%2F-1216412040) |
| [registerPinDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#639237593%2FFunctions%2F-1216412040) | [jvm]<br>open fun &lt;[T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#639237593%2FFunctions%2F-1216412040) : InternalDeviceInterface&gt; [registerPinDevice](../-c-r-i-c-k-i-t-hat-device-factory/index.md#639237593%2FFunctions%2F-1216412040)(p0: PinInfo, p1: [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#639237593%2FFunctions%2F-1216412040)&gt;): [T](../-c-r-i-c-k-i-t-hat-device-factory/index.md#639237593%2FFunctions%2F-1216412040) |
| [reopen](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-1958343240%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [reopen](../-c-r-i-c-k-i-t-hat-device-factory/index.md#-1958343240%2FFunctions%2F-1216412040)() |
| [start](../-c-r-i-c-k-i-t-hat-device-factory/index.md#98340538%2FFunctions%2F-1216412040) | [jvm]<br>open fun [start](../-c-r-i-c-k-i-t-hat-device-factory/index.md#98340538%2FFunctions%2F-1216412040)() |

## Properties

| Name | Summary |
|---|---|
| [i2CDevice](i2-c-device.md) | [jvm]<br>val [i2CDevice](i2-c-device.md): I2CDevice |
