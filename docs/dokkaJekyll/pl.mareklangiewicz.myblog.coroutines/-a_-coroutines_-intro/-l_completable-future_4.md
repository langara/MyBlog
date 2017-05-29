---
title: A_Coroutines_Intro.L_completableFuture_4 - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [L_completableFuture_4](.)

# L_completableFuture_4

`fun L_completableFuture_4(): Unit`

Use future related functions from kotlinx.coroutines

Important: both futures are started immediately

``` kotlin
"main: start".p
future {
    "main future: start".p
    val f1 = future {
        "f1: start".p
        delay(1000) // sleep 1s
        "f1: end".p
        1
    }
    val f2 = future {
        "f2: start".p
        delay(1000) // sleep 1s
        "f2: end".p
        2
    }
    "main future: before awaits".p
    val f1val = f1.await()
    "main future: after f1.await(): f1val = $f1val".p
    val f2val = f2.await()
    "main future: after f2.await(): f2val = $f2val".p
    val sum = f1val + f2val
    "main future: after awaits: sum = $sum".p
}
Thread.sleep(3000)
"main: end".p
```

