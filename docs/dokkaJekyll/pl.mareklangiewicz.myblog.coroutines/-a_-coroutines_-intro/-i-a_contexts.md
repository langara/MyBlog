---
title: A_Coroutines_Intro.IA_contexts - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [IA_contexts](.)

# IA_contexts

`fun IA_contexts(): Unit`

Different contexts example

``` kotlin
sample {
        "main: start".p
        val jobs = arrayListOf<Job>()
        jobs += launch(Unconfined) {
            // not confined -- will work with main thread
            "Unconfined".p
        }
        jobs += launch(context) {
            // context of the parent, runBlocking coroutine
            "context".p
        }
        jobs += launch(CommonPool) {
            // will get dispatched to ForkJoinPool.commonPool (or equivalent)
            "CommonPool".p
        }
        jobs += launch(newSingleThreadContext("MyOwnThread")) {
            // will get its own new thread
            "newSTC".p
        }
        "main: joining all jobs".p
        for (job in jobs)
            job.join()
        "main: end".p
    }
```

