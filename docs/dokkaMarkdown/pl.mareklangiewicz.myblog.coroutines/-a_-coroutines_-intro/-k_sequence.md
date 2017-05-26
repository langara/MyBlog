[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [K_sequence](.)

# K_sequence

`fun K_sequence(): Unit`

Sequence builder test

``` kotlin
val seq: Sequence<Int> = buildSequence {
    //delay(10) // this is forbidden
    yield(2)
    yield(4)
    yield(6)
}
for (i in seq) "$i".p
```

