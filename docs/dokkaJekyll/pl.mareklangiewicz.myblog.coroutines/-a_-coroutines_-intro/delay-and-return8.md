---
title: A_Coroutines_Intro.delayAndReturn8 - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [delayAndReturn8](.)

# delayAndReturn8

`suspend fun delayAndReturn8(): Int`

Delay and return 8 with logging

``` kotlin
"delayAndReturn8: start".p
delay(1000L)
"delayAndReturn8: end".p
return 8
```

