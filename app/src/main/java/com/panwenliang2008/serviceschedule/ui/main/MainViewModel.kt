package com.panwenliang2008.serviceschedule.ui.main

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blankj.utilcode.util.TimeUtils
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleEntity
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainViewModel
@Inject constructor(private val scheduleRepository: ScheduleRepository) : ViewModel() {
    // TODO: Implement the ViewModel

    private val _currentTime: MutableLiveData<String> = MutableLiveData()

    val currentTime: LiveData<String>
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

    fun insert(): Completable {
        return Completable.fromAction {
            val scheduleEntity = ScheduleEntity(0, "testName", "", "", "")
            scheduleRepository.insertSchedule(listOf(scheduleEntity))
        }
    }

    fun getSchedulByName(userName: String): Flowable<String> {
        return scheduleRepository.getScheduleByName(userName)
            .map { schedule -> schedule.name
            }
    }

}
