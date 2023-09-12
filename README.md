# Hardware Device Drivers in Kotlin

Herein are various drivers for some microprocessor peripherals, written in **Kotin** and using the [`diozero`](https://www.diozero.com) library.

Javadocs are at [kobots-devices](https://eagrahamjr.github.io/kobots-devices/)

* The "biggie" is a translation of the [Adafruit SeeSaw](src/main/kotlin/crackers/kobots/devices/expander/AdafruitSeeSaw.kt) microprocessor code, which is
  not complete.
* Another interesting note is the [PixelBuf](src/main/kotlin/crackers/kobots/devices/lighting/PixelBuf.kt) which, like it's Adafruit conterpart, underlies the various hardware-specific `NepPixel` (WS281x) interfaces. This deviates quite a bit from the `diozero` implementation, as I preferred using Java `Color` constructs since they are available.

:bangbang: **STILL UNDER CONSTRUCTION!!!!** These items were constructed and verified **only** on a Raspberry Pi, but _should_ work where the [`diozero`](https://www.diozero.com) **main branch** library will work.

![Just Build](https://github.com/EAGrahamJr/kobots-devices/actions/workflows/build.yaml/badge.svg) ![Kotlin](https://badgen.net/badge/Kotlin/1.8.22/purple) ![Java](https://badgen.net/badge/Java/17/orange) ![Apache License](https://badgen.net/github/license/EAGrahamJr/kobots-devices)

## Licensing

Many driver translations are based on code from the [Adafruit Circuit Python](https://github.com/adafruit), which are generally licensed under the [MIT License](https://opensource.org/license/mit/), The [`diozero`](https://www.diozero.com) library is similarly licensed.

## Building

This project uses [Gradle](https://gradle.org), so the only thing you need is a compatible JDK<sup>**1**</sup>. Additionally, because the project is [Kotlin](https://kotlinlang.org) and uses the _Kotlin Gradle plugin_, a Kotlin installation is also not necessary.<sup>**2**</sup>

A default build will use the [gradle-plugins](https://github.com/EAGrahamJr/gradle-scripts) to publish to the "local" Maven repository.

---

<sup>**1**</sup>Kotlin 1.8.22/Java 17 is the current build target.<br/>
<sup>**2**</sup>This project _may_ depend on _my_ `diozero` changes as they may be ahead of the main repository branch. See the GitHub [actions](.github/workflows/build.yaml) for which version is being used. 
