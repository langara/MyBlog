---
title: A_Coroutines_Intro.D_introduceJob - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [D_introduceJob](.)

# D_introduceJob

`fun D_introduceJob(): Unit`

Use Job class to handle coroutine state and to wait (non blocking) for it to finish

``` kotlin
sample {
        val job = launch(CommonPool) {
            delay(1000L)
            "World!".p
        }
        "Hello,".p
        job.join() // this suspending function (join) waits for job to finish
    }
```

