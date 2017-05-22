[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [B_runBlocking](.)

# B_runBlocking

`fun B_runBlocking(): Unit`

Bridging blocking and nonblocking worlds

``` kotlin
runBlocking {
    delay(1000)
    "1000".p
    delay(1000)
    "2000".p
    delay(1000)
    "3000".p
}
```

