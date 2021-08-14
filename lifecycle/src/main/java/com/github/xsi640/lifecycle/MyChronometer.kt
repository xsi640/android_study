package com.github.xsi640.lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.*

class MyChronometer(
    context: Context,
    attrs: AttributeSet
) : LifecycleObserver, Chronometer(context, attrs) {

    var elapsedTime: Long = 0L

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun startMeter() {
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun stopMeter() {
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }
}