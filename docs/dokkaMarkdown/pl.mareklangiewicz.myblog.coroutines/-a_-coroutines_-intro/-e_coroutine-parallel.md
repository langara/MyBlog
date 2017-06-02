[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [E_coroutineParallel](.)

# E_coroutineParallel

`fun E_coroutineParallel(): Unit`

Run suspending functions in parallel

``` kotlin
sample {
        "start".p
        val a1 = async(context) { delayAndReturn7() } // we do NOT await for it yet (but it already starts the `delayAndReturn7`)
        val a2 = async(context) { delayAndReturn8() } // we do NOT await for it yet (but it already starts the `delayAndReturn8`)
        val result = a1.await() + a2.await()
        "end result: $result.".p // it will take ONE second to print it
    }
```

