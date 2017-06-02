---
title: A_Coroutines_Intro.E_coroutineIsSequential - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [E_coroutineIsSequential](.)

# E_coroutineIsSequential

`fun E_coroutineIsSequential(): Unit`

Suspending functions are called sequentially

``` kotlin
sample {
        "start".p
        val result = delayAndReturn7() + delayAndReturn8()
        "end result: $result.".p // it will take two seconds to print it
    }
```

