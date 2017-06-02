[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [delayAndReturn7](.)

# delayAndReturn7

`suspend fun delayAndReturn7(): Int`

Delay and return 7 with logging

``` kotlin
"delayAndReturn7: start".p
delay(1000L)
"delayAndReturn7: end".p
return 7
```

