[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [E_extractSuspendingFunction](.)

# E_extractSuspendingFunction

`fun E_extractSuspendingFunction(): Unit`

Extract suspending function

FIXME: this throws an exception and I don't know why...

``` kotlin
sample {
        val job = launch(CommonPool) {
            delayAndPrintWorld()
        }
        println("Hello,")
        job.join() // this suspending function (join) waits for job to finish
    }
```

