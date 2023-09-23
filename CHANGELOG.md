# Changelog

## v 0.1.5 - 9/23/2023

- Mostly working around the MQTT client to add resiliency
- Update copyright notices in files

## v 0.1.4 - 9/3/2023

- finish/fix luminosity reading for VL6180X sensor

## v 0.1.3 - 8/25/2023

- Added MQTT support classes

## v 0.1.2 - 8/7/2023

- Add a new class `GamepadButtons` to handle reading all `GamepadQT` buttons at once
- Fix up some dependencies

## v 0.1.1 - 7/28/2023

- Fix `fill` bug in `PixelBuf` (not retaining "current" colors)
- Add new `AdafruitSeesaw` microprocessor types
- Fix some visibility in `CRICHITHat` support classes

## v 0.1.0 - 6/28/2023

- Breaking API changes for v 0.1.0
  - Specifically around the `CRICKITHat` and `AdafruitSeesaw` devices
- Seesaw: Bulk read needs same 4-byte treatment as single pin
- Seesaw: Fix missing extra bytes for pins >= 16 and < 32
- Added new `GamepadQT` device and moved the `NeoKey`

## v 0.0.6 - 6/14/2023

- Finally implement bulk read.
- Optimized NeoPixel to Seesaw writes.

## v 0.0.5 - 6/11/2023

- Fixup some visibility pieces and docs.
- Missing dep and apparently some formatting

## v 0.0.4 - 6/8/2023

- Started adding new "time of flight" range finder VL6180X
- Open up constructor
- Fix param name

## v 0.0.3 - 6/6/2023

- Refactor Neopixel device

## v 0.0.1 - 5/28/2023

The overall theme of this version was to split from the "main" robotics project.

- Devices updated to match what I'm expecting :grin:
- Pages setup
- Fix up docs and some build stuff
- GFM output is ugly
- Dokka keeps sucking up everything
- Add convenience function to set all pixels to a color.
- Add dependent builds
- Put it in thr right place
- Create main.yml
- Add auto-build and fix incorrectly formatted doc
- Remove extremely dangerous lazy junk and fix progress bar.
- Publish docs via home-built plugins and Dokka
- Get the current color of a pixel
- Read all the buttons at once instead of forcing external iterator.
- Refactor NeoPixel/WS2811 LEDs into more compatible classes.
- Create LICENSE
- Re-configure repo as standalone project.

## v 0.0.0 - 4/18/2023

These changes include those made on the robotics project prior to splitting.

- Remove ops (multi-threading is not good).
- Fix class name and package
- New device: NeoKey 1x4 "keyboard"
- Reduce servo madness to a simpler "where do I need to be"
- Clear the screen and some helpers.
- Tweak up builds/dependencies and run-time scripts.
- Code re-use.
- Re-set read delay.
- Combining a servo, the range-finder, and OLED display.
- Alternate contructor just from an image.
- Fix formatting/tests, etc.
- Allow direct useage of drive ports (e.g. solenoids)
- Tweak bus, run gauge stuff faster
- Steppers added via `diozero` branch.
- Add another operator for PixelBuf
- Fix "double" device close stuff for PWM things.
- Comparison between events and "stupid polling loop"
- Duplicate code.
- Close some things when closed.
- Not implemented on Pi Hat?
- Collapse the Hat and SeeSaw codes (since the Hat is just pinouts)
- Added blocking I/O for the CRICKIT.
- Might help if it compiled...
- Fix **ALL** the formatting, language, and other garbage.
- More docs so I don't forget why I did this
- Control a set of NeoPixels attached to the CRICKIT.
- Starting to get TOO junky, so a bit of cleanup and refactoring.
- API cleanups and docs
- Forgot the touchpads
- Check that no devices can be open on same port.
- Tweak all the things for gauges.
- Remove un-runnable thing
- A very simple gauge without big libraries.
- Motor verified working.
- Finishing off the shim.
- Staring to go into rabbit holes
- Pimoroni LEDShim (#1)
- Align IDE formatting with ktlint and rename things
- lint picking
- SSD working!!!!!
- Merge branch 'main' into oled
- Fix threading issues and throw around some coroutine stuff
- Remove uplidate test and ensure property is set
- Finish moving to full factory stuff.
- Helpers to get "real" devices.
- Split out "device factory" and add tests
- Add servos and refactor
- Test cleanup
- Add "other hardware" since analog writes does things.
- Test tweaks and some minor updates.
- Signals working (still needs more tests)
- RENAME!
- Rescued CRICKIT expander from GitHub mistakes (PBKAC).
- Keeping up with diozero and tweaking ADS
- Refactor ADS to be a device factory.
- Test maybe?
- May or may not be working due to possibly non-functional display.
- Lint gathering, etc.
- Finish off the prox/light sensor
- Almost done with sensor
- First Qwiic device - light and proximity sensor
- Initial stepper work is actually stepping
- Threading stuff - definitely heats up the Pi
- DSL and Kotest
- First cat-nose bonker robot
- Run **REMOTE**!!!
- Go back and get missed lesson :grin:
- Clean up after LCD issues fixed.
- Back to having fun: Kotlin LCD and a progress bar
- LCD stuff
- A kind of port for a specific 2x16 LCD display.
- Adding basic action and tweaking convenience.
- Shift-register using 4-digit 8-segment
- Shift register and 8-segment display
- Stepper motor driver
- Fix a util and setup lesson 15 (to be ignored).
- Build stuff and formatting
- Update docs
- Tweaks to ADS7830, motor lesson.
- Lessons on ADC and some clean up.
- Turning this into something resembling a real project.
- RGB LED and a different pinout picture.
- A debounced button with Java construtor checks
- Notes and first extensions.
- Set up project
