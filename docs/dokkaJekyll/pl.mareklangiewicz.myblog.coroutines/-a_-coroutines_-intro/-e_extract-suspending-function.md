---
title: A_Coroutines_Intro.E_extractSuspendingFunction - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [E_extractSuspendingFunction](.)

# E_extractSuspendingFunction

`fun E_extractSuspendingFunction(): Unit`

Extract suspending function

``` kotlin
sample {
        val job = launch(CommonPool) {
            delayAndPrintWorld()
        }
        "Hello,".p
        job.join() // this suspending function (join) waits for job to finish
    }
```

