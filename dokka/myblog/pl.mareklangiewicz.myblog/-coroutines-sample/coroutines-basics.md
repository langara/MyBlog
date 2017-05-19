[myblog](../../index.md) / [pl.mareklangiewicz.myblog](../index.md) / [CoroutinesSample](index.md) / [coroutinesBasics](.)

# coroutinesBasics

`fun coroutinesBasics(): Unit`

## Lets try something simple

``` kotlin
launch(CommonPool) {
    delay(1000L)
    println("World!")
}
println("Hello,")
Thread.sleep(2000L)
```

