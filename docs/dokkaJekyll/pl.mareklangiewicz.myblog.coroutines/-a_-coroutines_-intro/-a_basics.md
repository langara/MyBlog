---
title: A_Coroutines_Intro.A_basics - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [A_basics](.)

# A_basics

`fun A_basics(): Unit`

First coroutine

``` kotlin
launch(CommonPool) {
    delay(1000L)
    println("World!")
}
println("Hello,")
Thread.sleep(2000L)
```

