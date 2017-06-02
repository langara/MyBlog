[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [massiveRun](.)

# massiveRun

`suspend fun massiveRun(context: CoroutineContext, action: SuspendFunction0<Unit>): Unit`

Runs given action a million times using thousand coroutines

``` kotlin
val n = 1000 // number of coroutines to launch
val k = 1000 // times an action is repeated by each coroutine
val time = measureTimeMillis {
    val jobs = List(n) {
        launch(context) {
            repeat(k) { action() }
        }
    }
    jobs.forEach { it.join() }
}
```

