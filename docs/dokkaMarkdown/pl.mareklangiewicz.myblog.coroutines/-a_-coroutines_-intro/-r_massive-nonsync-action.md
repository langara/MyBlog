[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [R_massiveNonsyncAction](.)

# R_massiveNonsyncAction

`fun R_massiveNonsyncAction(): Unit`

Massive non sync action

``` kotlin
sample {
        "start".p
        var counter = 0 // @Volatile would not help much; AtomicInteger would work correctly.
//        val context = newSingleThreadContext("single") // this will increment counter correctly all the times
        val context = newFixedThreadPoolContext(2, "double") // this should cause some sync errors
//        val context = CommonPool // this should cause some sync errors on systems with multiple CPUs (more than 2)
        massiveRun(context) {
            counter ++
        }
        "end. counter: $counter (should be 1000000) (error: ${1000000-counter})".p
    }
```

