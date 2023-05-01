//[kobots-devices](../../../index.md)/[crackers.kobots.devices.sensors](../index.md)/[VCNL4040](index.md)

# VCNL4040

[jvm]\
class [VCNL4040](index.md)(delegate: I2CDevice) : LuminositySensorInterface

Proximity and ambient light sensor on I2C bus.

- 
   [Datasheet](https://www.vishay.com/docs/84274/vcnl4040.pdf)
- 
   [Adafruit guide](https://learn.adafruit.com/adafruit-vcnl4040-proximity-sensor?view=all)

## Constructors

| | |
|---|---|
| [VCNL4040](-v-c-n-l4040.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>constructor(controller: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, address: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = QWIIC_I2C_ADDRESS)constructor(delegate: I2CDevice) |

## Types

| Name | Summary |
|---|---|
| [AmbientLightIntegrationTime](-ambient-light-integration-time/index.md) | [jvm]<br>enum [AmbientLightIntegrationTime](-ambient-light-integration-time/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.AmbientLightIntegrationTime](-ambient-light-integration-time/index.md)&gt; |
| [AmbientLightPersistence](-ambient-light-persistence/index.md) | [jvm]<br>enum [AmbientLightPersistence](-ambient-light-persistence/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.AmbientLightPersistence](-ambient-light-persistence/index.md)&gt; |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [LEDCurrent](-l-e-d-current/index.md) | [jvm]<br>enum [LEDCurrent](-l-e-d-current/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.LEDCurrent](-l-e-d-current/index.md)&gt; |
| [LEDDutyCycle](-l-e-d-duty-cycle/index.md) | [jvm]<br>enum [LEDDutyCycle](-l-e-d-duty-cycle/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.LEDDutyCycle](-l-e-d-duty-cycle/index.md)&gt; |
| [ProximityIntegrationTime](-proximity-integration-time/index.md) | [jvm]<br>enum [ProximityIntegrationTime](-proximity-integration-time/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.ProximityIntegrationTime](-proximity-integration-time/index.md)&gt; |
| [ProximityInterruptType](-proximity-interrupt-type/index.md) | [jvm]<br>enum [ProximityInterruptType](-proximity-interrupt-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.ProximityInterruptType](-proximity-interrupt-type/index.md)&gt; |
| [ProximityMultipulse](-proximity-multipulse/index.md) | [jvm]<br>enum [ProximityMultipulse](-proximity-multipulse/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.ProximityMultipulse](-proximity-multipulse/index.md)&gt; |
| [ProximityOperation](-proximity-operation/index.md) | [jvm]<br>enum [ProximityOperation](-proximity-operation/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.ProximityOperation](-proximity-operation/index.md)&gt; |
| [ProximityResolution](-proximity-resolution/index.md) | [jvm]<br>enum [ProximityResolution](-proximity-resolution/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[VCNL4040.ProximityResolution](-proximity-resolution/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [activeForceModeTrigger](active-force-mode-trigger.md) | [jvm]<br>fun [activeForceModeTrigger](active-force-mode-trigger.md)()<br>Outputs one data cycle - see p. 10 |
| [close](close.md) | [jvm]<br>open override fun [close](close.md)() |
| [dumpRegisters](dump-registers.md) | [jvm]<br>fun [dumpRegisters](dump-registers.md)() |
| [getLuminosity](get-luminosity.md) | [jvm]<br>open override fun [getLuminosity](get-luminosity.md)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [isAmbientLightHigh](is-ambient-light-high.md) | [jvm]<br>fun [isAmbientLightHigh](is-ambient-light-high.md)(interruptStatus: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isAmbientLightLow](is-ambient-light-low.md) | [jvm]<br>fun [isAmbientLightLow](is-ambient-light-low.md)(interruptStatus: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isEnteringProtectionMode](is-entering-protection-mode.md) | [jvm]<br>fun [isEnteringProtectionMode](is-entering-protection-mode.md)(interruptStatus: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isProximityClose](is-proximity-close.md) | [jvm]<br>fun [isProximityClose](is-proximity-close.md)(interruptStatus: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isProximityFar](is-proximity-far.md) | [jvm]<br>fun [isProximityFar](is-proximity-far.md)(interruptStatus: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Properties

| Name | Summary |
|---|---|
| [ambientLight](ambient-light.md) | [jvm]<br>val [ambientLight](ambient-light.md): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [ambientLightEnabled](ambient-light-enabled.md) | [jvm]<br>var [ambientLightEnabled](ambient-light-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The bit for this flag is actually *inverted* as it's technically an &quot;is shutdown&quot; flag |
| [ambientLightHighThreshold](ambient-light-high-threshold.md) | [jvm]<br>var [ambientLightHighThreshold](ambient-light-high-threshold.md): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [ambientLightIntegrationTime](ambient-light-integration-time.md) | [jvm]<br>var [ambientLightIntegrationTime](ambient-light-integration-time.md): [VCNL4040.AmbientLightIntegrationTime](-ambient-light-integration-time/index.md) |
| [ambientLightInterruptPersistence](ambient-light-interrupt-persistence.md) | [jvm]<br>var [ambientLightInterruptPersistence](ambient-light-interrupt-persistence.md): [VCNL4040.AmbientLightPersistence](-ambient-light-persistence/index.md) |
| [ambientLightInterruptsEnabled](ambient-light-interrupts-enabled.md) | [jvm]<br>var [ambientLightInterruptsEnabled](ambient-light-interrupts-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [ambientLightLowThreshold](ambient-light-low-threshold.md) | [jvm]<br>var [ambientLightLowThreshold](ambient-light-low-threshold.md): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [interruptStatus](interrupt-status.md) | [jvm]<br>val [interruptStatus](interrupt-status.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [proximity](proximity.md) | [jvm]<br>val [proximity](proximity.md): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [proximityActiveForceEnabled](proximity-active-force-enabled.md) | [jvm]<br>var [proximityActiveForceEnabled](proximity-active-force-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [proximityEnabled](proximity-enabled.md) | [jvm]<br>var [proximityEnabled](proximity-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The bit for this flag is actually *inverted* as it's technically an &quot;is shutdown&quot; flag |
| [proximityHighResolution](proximity-high-resolution.md) | [jvm]<br>var [proximityHighResolution](proximity-high-resolution.md): [VCNL4040.ProximityResolution](-proximity-resolution/index.md) |
| [proximityHighThreshold](proximity-high-threshold.md) | [jvm]<br>var [proximityHighThreshold](proximity-high-threshold.md): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [proximityIntegrationTime](proximity-integration-time.md) | [jvm]<br>var [proximityIntegrationTime](proximity-integration-time.md): [VCNL4040.ProximityIntegrationTime](-proximity-integration-time/index.md) |
| [proximityInterruptPersistence](proximity-interrupt-persistence.md) | [jvm]<br>var [proximityInterruptPersistence](proximity-interrupt-persistence.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [proximityInterrupts](proximity-interrupts.md) | [jvm]<br>var [proximityInterrupts](proximity-interrupts.md): [VCNL4040.ProximityInterruptType](-proximity-interrupt-type/index.md) |
| [proximityLEDCurrent](proximity-l-e-d-current.md) | [jvm]<br>var [proximityLEDCurrent](proximity-l-e-d-current.md): [VCNL4040.LEDCurrent](-l-e-d-current/index.md) |
| [proximityLEDDutyCycle](proximity-l-e-d-duty-cycle.md) | [jvm]<br>var [proximityLEDDutyCycle](proximity-l-e-d-duty-cycle.md): [VCNL4040.LEDDutyCycle](-l-e-d-duty-cycle/index.md) |
| [proximityLowThreshold](proximity-low-threshold.md) | [jvm]<br>var [proximityLowThreshold](proximity-low-threshold.md): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [proximityMultipulse](proximity-multipulse.md) | [jvm]<br>var [proximityMultipulse](proximity-multipulse.md): [VCNL4040.ProximityMultipulse](-proximity-multipulse/index.md) |
| [proximityOperation](proximity-operation.md) | [jvm]<br>var [proximityOperation](proximity-operation.md): [VCNL4040.ProximityOperation](-proximity-operation/index.md) |
| [proximitySmartPersistenceEnabled](proximity-smart-persistence-enabled.md) | [jvm]<br>var [proximitySmartPersistenceEnabled](proximity-smart-persistence-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [sunlightCancelEnabled](sunlight-cancel-enabled.md) | [jvm]<br>var [sunlightCancelEnabled](sunlight-cancel-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [whiteLight](white-light.md) | [jvm]<br>val [whiteLight](white-light.md): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [whiteLightEnabled](white-light-enabled.md) | [jvm]<br>var [whiteLightEnabled](white-light-enabled.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The bit for this flag is actually *inverted* |
