package com.panwenliang2008.serviceschedule.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.os.Handler
import android.view.Menu
import com.blankj.utilcode.util.TimeUtils
import com.blankj.utilcode.util.TimeUtils.getNowString
import com.blankj.utilcode.util.Utils
import java.util.*
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _currentTime : MutableLiveData<String> = MutableLiveData()

    val currentTime : LiveData<String>
    get() = _currentTime

    private val timeHandler = Handler()
    private val timerRunnable = object : Runnable {
        override fun run() {
            _currentTime.value = TimeUtils.getNowString()
            timeHandler.postDelayed(this, TimeUnit.SECONDS.toMillis(1))
        }
    }

    init {
        timeHandler.post(timerRunnable)
    }
}
