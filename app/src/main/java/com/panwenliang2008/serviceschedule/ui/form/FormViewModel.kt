package com.panwenliang2008.serviceschedule.ui.form

import androidx.lifecycle.ViewModel;
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleEntity
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler
import java.util.*
import javax.inject.Inject

class FormViewModel
@Inject constructor(private var scheduleRepository: ScheduleRepository) : ViewModel() {
    // TODO: Implement the ViewModel

    fun getSchedulByDate(date: String): Flowable<ScheduleEntity> {
        return scheduleRepository.getScheduleByDate(date)
    }
}
