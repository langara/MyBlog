[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [F_coroutinesAreLightweight](.)

# F_coroutinesAreLightweight

`fun F_coroutinesAreLightweight(): Unit`

Run 100 000 coroutines in parallel

Coroutines are extremely lightweight so we can start **A LOT** of them

``` kotlin
sample {
        val jobs = List(100_000) {
            // create a lot of coroutines and list their jobs
            launch(CommonPool) {
                delay(1000L)
                print(".")
            }
        }
        jobs.forEach { it.join() } // wait for all jobs to complete
    }
```

