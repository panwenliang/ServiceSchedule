package com.panwenliang2008.serviceschedule.ui.main

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.blankj.utilcode.util.TimeUtils
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleEntity
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleRepository
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel
@Inject constructor(scheduleRepository: ScheduleRepository) : ViewModel() {
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

        var entity:ScheduleEntity = ScheduleEntity(1, "name", "0", "1", "2")
        scheduleRepository.insertSchedule(listOf(entity)).subscribe(Consumer {
            it
        })

        scheduleRepository.loadSchedule().subscribe(Consumer {
            it.get(0)
        })
    }
}
