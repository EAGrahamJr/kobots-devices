//[kobots-devices](../../../index.md)/[crackers.kobots.utilities](../index.md)/[SimpleAverageMeasurement](index.md)

# SimpleAverageMeasurement

[jvm]\
class [SimpleAverageMeasurement](index.md)(val bucketSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val initialValue: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) = Float.MAX_VALUE)

Captures data in a simple FIFO buffer for averaging. Probably not suitable for large sizes.

## Constructors

| | |
|---|---|
| [SimpleAverageMeasurement](-simple-average-measurement.md) | [jvm]<br>constructor(bucketSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), initialValue: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) = Float.MAX_VALUE) |

## Functions

| Name | Summary |
|---|---|
| [plusAssign](plus-assign.md) | [jvm]<br>operator fun [plusAssign](plus-assign.md)(v: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [bucketSize](bucket-size.md) | [jvm]<br>val [bucketSize](bucket-size.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [initialValue](initial-value.md) | [jvm]<br>val [initialValue](initial-value.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [value](value.md) | [jvm]<br>val [value](value.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
