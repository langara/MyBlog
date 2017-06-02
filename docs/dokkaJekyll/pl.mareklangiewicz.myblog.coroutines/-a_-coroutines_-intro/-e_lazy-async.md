---
title: A_Coroutines_Intro.E_lazyAsync - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [E_lazyAsync](.)

# E_lazyAsync

`fun E_lazyAsync(): Unit`

Run suspending functions in parallel, but lazily

``` kotlin
sample {
        "start".p
        val a1 = async(context, CoroutineStart.LAZY) { delayAndReturn7() }
        val a2 = async(context, CoroutineStart.LAZY) { delayAndReturn8() }
        val result = a1.await() + a2.await()
        "end result: $result.".p // it will take TWO second to print it
    }
```

