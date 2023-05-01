//[kobots-devices](../../index.md)/[crackers.kobots.devices](index.md)/[rotate](rotate.md)

# rotate

[jvm]\
fun StepperMotorInterface.[rotate](rotate.md)(degrees: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), direction: StepperMotorInterface.Direction = Direction.FORWARD, pause: [Duration](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html) = Duration.ofMillis(5), interruptus: () -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { false })

Rotate with a simple interruption - note this **can** be bad if the interruption method is left as the default.
