[pl.mareklangiewicz.myblog.coroutines](../../index.md) / [A_Coroutines_Intro](../index.md) / [Receiver](.)

# Receiver

`interface Receiver<T> : `[`AutoCloseable`](http://docs.oracle.com/javase/6/docs/api/java/lang/AutoCloseable.html)

Something that you can ask for items, but it can suspend when item is not available yet

``` kotlin
/**
     * Something that you can ask for items, but it can suspend when item is not available yet
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Receiver
     */
    interface Receiver<T> : AutoCloseable {
        /**
         * Receives next item immediately or suspends if no item is ready
         */
        suspend fun receive(): T
    }
```

### Functions

| Name | Summary |
|---|---|
| [receive](receive.md) | `abstract suspend fun receive(): T`<br>Receives next item immediately or suspends if no item is ready |
