[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [N_fibonacciChannels](.)

# N_fibonacciChannels

`fun N_fibonacciChannels(): Unit`

Use channels to implement fibonacci numbers generator

``` kotlin
val c = Channel<Int>(2) // experiment with different capacity
launch(CommonPool) {
    fibonacci(10, c)
}
launch(CommonPool) {
    for (x in c) {
        delay(300)
        "*********************** received $x".p
    }
}
Thread.sleep(3000)
```

