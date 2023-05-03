# Extensions and Shared Junk

STILL UNDER CONSTRUCTION!!!! Check out the source directories for devices and utilities.

![Just Build](https://github.com/EAGrahamJr/kobots-devices/actions/workflows/build.yaml/badge.svg)

The "biggie" is a translation of the [Adafruit SeeSaw](src/main/kotlin/crackers/kobots/devices/expander/AdafruitSeeSaw.kt) microprocessor code, which is
not complete. Also note it has only been verified on a Raspberry Pi.

Another interesting note is the [PixelBuf](src/main/kotlin/crackers/kobots/devices/lighting/PixelBuf.kt) which, like it's Adafruit conterpart, underlies the various hardware-specific `NepPixel` (WS281x) interfaces. This deviates quite a bit from the `diozero` implementation, but I preferred using Java `Color` constructs since they are available.

## Building

This project uses [Gradle](https://gradle.org), so the only thing you need is a compatible JDK<sup>**1**</sup>. Additionally, because the project is [Kotlin](https://kotlinlang.org) and uses the _Kotlin Gradle plugin_, a Kotlin installation is also not necessary.

A default build will use the [gradle-plugins](https://github.com/EAGrahamJr/gradle-scripts) to publish to the "local" Maven repository.

---

<sup>**1**</sup>Java 17 is the current build target.
