//[kobots-devices](../../../index.md)/[crackers.kobots.devices](../index.md)/[I2CSubRegister](index.md)

# I2CSubRegister

[jvm]\
interface [I2CSubRegister](index.md)&lt;[N](index.md) : [Number](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)&gt;

Creates a read/write sub-register (e.g. bit-mapped values). The values read/write are based on a bit-mask - e.g. this will extract and write only a *subset* of a register value. This is for those occasions that an I2C register contains multiple values.

- 
   the `read` operation will shift the value &quot;down&quot; to provide the value
- 
   the `write` operation will shift the value &quot;up&quot; to its proper bit-location and not change or influence other bits in the register

## Functions

| Name | Summary |
|---|---|
| [read](read.md) | [jvm]<br>abstract fun [read](read.md)(): [N](index.md) |
| [write](write.md) | [jvm]<br>abstract fun [write](write.md)(data: [N](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [mask](mask.md) | [jvm]<br>abstract val [mask](mask.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
