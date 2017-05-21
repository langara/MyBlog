[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [B_basics](.)

# B_basics

`fun B_basics(): Unit`

some B_basics

## Lets try something simple

``` kotlin
launch(CommonPool) {
    delay(1000L)
    println("World!")
}
println("Hello,")
Thread.sleep(2000L)
```

