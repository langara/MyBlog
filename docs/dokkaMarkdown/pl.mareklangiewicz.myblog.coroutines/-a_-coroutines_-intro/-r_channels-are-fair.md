[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [R_channelsAreFair](.)

# R_channelsAreFair

`fun R_channelsAreFair(): Unit`

Channels are fair

``` kotlin
sample {
        val table = Channel<Ball>() // a shared table
        launch(context) { player("ping", table) }
        launch(context) { player("pong", table) }
//        launch(context) { player("PENGGG", table) }
        table.send(Ball(0)) // serve the ball
        delay(2000) // delay 1 second
        table.receive() // game over, grab the ball
    }
```

