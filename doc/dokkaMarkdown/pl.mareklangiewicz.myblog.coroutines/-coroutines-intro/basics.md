[pl.mareklangiewicz.myblog.coroutines](../index.md) / [CoroutinesIntro](index.md) / [basics](.)

# basics

`fun basics(): Unit`

some basics

## Lets try something simple

``` kotlin
launch(CommonPool) {
    delay(1000L)
    println("World!")
}
println("Hello,")
Thread.sleep(2000L)
```

