//[kobots-devices](../../index.md)/[crackers.kobots.devices.lighting](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [IS31FL3731](-i-s31-f-l3731/index.md) | [jvm]<br>abstract class [IS31FL3731](-i-s31-f-l3731/index.md)(i2CDevice: I2CDevice = DEFAULT_DEVICE, frames: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt; = (0..7)) : DeviceInterface<br>Represents an IS31LF3731 charlieplex IC. All pixel operations are **direct write** to the device, no buffering. The display has (by default) 8 addressable &quot;frames&quot; (memory buffers) that contain the display information. |
| [NeoKey](-neo-key/index.md) | [jvm]<br>class [NeoKey](-neo-key/index.md)(i2CDevice: I2CDevice = DEFAULT_I2C) : DeviceInterface, [WS2811](-w-s2811/index.md)<br>Adafruit https://www.adafruit.com/product/4980 |
| [PimoroniLEDShim](-pimoroni-l-e-d-shim/index.md) | [jvm]<br>class [PimoroniLEDShim](-pimoroni-l-e-d-shim/index.md)(shimDevice: I2CDevice = DEFAULT_SHIM_DEVICE) : [IS31FL3731](-i-s31-f-l3731/index.md) |
| [PixelBuf](-pixel-buf/index.md) | [jvm]<br>abstract class [PixelBuf](-pixel-buf/index.md)(val size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val byteOrder: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;BGR&quot;, brightness: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) = 1.0f, autoWriteEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, header: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)? = null, trailer: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)? = null) : [WS2811](-w-s2811/index.md)<br>A set of one or more WS2811 addressable-LEDs. |
| [WS2811](-w-s2811/index.md) | [jvm]<br>interface [WS2811](-w-s2811/index.md)<br>Defines [WS2811](https://cdn-shop.adafruit.com/datasheets/WS2811.pdf) aka **NeoPixels**. |

## Properties

| Name | Summary |
|---|---|
| [DEFAULT_SHIM_ADDRESS](-d-e-f-a-u-l-t_-s-h-i-m_-a-d-d-r-e-s-s.md) | [jvm]<br>const val [DEFAULT_SHIM_ADDRESS](-d-e-f-a-u-l-t_-s-h-i-m_-a-d-d-r-e-s-s.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 117 |
