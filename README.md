# Extensions and Shared Junk

STILL UNDER CONSTRUCTION!!!! Check out the source directories for devices and utilities.

The "biggie" is a translation of the [Adafruit SeeSaw](src/main/kotlin/crackers/kobots/devices/expander/AdafruitSeeSaw.kt) microprocessor code, which is not complete. Also note it has only been verified on a Raspberry Pi.

Another interesting note is the [PixelBuf](src/main/kotlin/crackers/kobots/devices/lighting/PixelBuf.kt) which, like it's Adafruit conterpart, underlies the various hardware-specific `NepPixel` (WS281x) interfaces. This deviates quite a bit from the `diozero` implementation, but I preferred using Java `Color` constructs since they are available.
