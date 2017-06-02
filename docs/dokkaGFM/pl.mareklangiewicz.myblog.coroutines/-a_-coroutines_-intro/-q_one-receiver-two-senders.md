[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [Q_oneReceiverTwoSenders](.)

# Q_oneReceiverTwoSenders

`fun Q_oneReceiverTwoSenders(): Unit`

One receiver, two senders

``` kotlin
sample {
        val channel = Channel<String>()
        launch(context) { channel.sendPeriodically("foo200", 200) }
        launch(context) { channel.sendPeriodically("BAR500", 500) }
        for (s in channel.take(context, 6))
            s.p
    }
```

