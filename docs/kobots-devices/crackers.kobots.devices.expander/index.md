//[kobots-devices](../../index.md)/[crackers.kobots.devices.expander](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AdafruitSeeSaw](-adafruit-see-saw/index.md) | [jvm]<br>open class [AdafruitSeeSaw](-adafruit-see-saw/index.md)(i2CDevice: I2CDevice, val initReset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : DeviceInterface<br>An I2C to whatever helper chip. Note that this chip does **not** use &quot;normal&quot; I2C registers, but rather selects &quot;registry&quot; locations with write before read. |
| [ADS7830](-a-d-s7830/index.md) | [jvm]<br>class [ADS7830](-a-d-s7830/index.md)(val i2CDevice: I2CDevice = I2CDevice(1, DEFAULT_ADDRESS)) : AbstractDeviceFactory, AnalogInputDeviceFactoryInterface<br>The [ADS7830 ](https://cdn.datasheetspdf.com/pdf-down/A/D/S/ADS7830-etcTI.pdf) is a single-supply, low-power, 8-bit data acquisition device that features a serial I2C interface and an 8-channel multiplexer.. |
| [CRICKITHat](-c-r-i-c-k-i-t-hat/index.md) | [jvm]<br>class [CRICKITHat](-c-r-i-c-k-i-t-hat/index.md)(i2CDevice: I2CDevice = defaultI2CDevice, val initReset: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true) : [AdafruitSeeSaw](-adafruit-see-saw/index.md)<br>CRICKIT Hat pin definitions for the SeeSaw device. |
| [CRICKITHatDeviceFactory](-c-r-i-c-k-i-t-hat-device-factory/index.md) | [jvm]<br>class [CRICKITHatDeviceFactory](-c-r-i-c-k-i-t-hat-device-factory/index.md)(val seeSaw: [AdafruitSeeSaw](-adafruit-see-saw/index.md) = CRICKITHat()) : AbstractDeviceFactory, GpioDeviceFactoryInterface, AnalogInputDeviceFactoryInterface, ServoDeviceFactoryInterface, PwmOutputDeviceFactoryInterface |
| [CRICKITNeoPixel](-c-r-i-c-k-i-t-neo-pixel/index.md) | [jvm]<br>class [CRICKITNeoPixel](-c-r-i-c-k-i-t-neo-pixel/index.md) : [PixelBuf](../crackers.kobots.devices.lighting/-pixel-buf/index.md)<br>NeoPixel handling via the SeeSaw |
