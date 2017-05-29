[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [L_completableFuture_5](.)

# L_completableFuture_5

`fun L_completableFuture_5(): Unit`

Use prepareFuture to make last example more lazy and simple

Now we pause two times when waiting for f1 and then for f2

``` kotlin
"main: start".p
future {
    "main future: start".p
    val f1 = prepareFuture {
        "f1: start".p
        delay(1000) // sleep 1s
        "f1: end".p
        1
    }
    val f2 = prepareFuture {
        "f2: start".p
        delay(1000) // sleep 1s
        "f2: end".p
        2
    }
    "main future: before awaits".p
    val f1val = f1().await()
    "main future: after f1.await(): f1val = $f1val".p
    val f2val = f2().await()
    "main future: after f2.await(): f2val = $f2val".p
    val sum = f1val + f2val
    "main future: after awaits: sum = $sum".p
}
Thread.sleep(3000)
"main: end".p
```

