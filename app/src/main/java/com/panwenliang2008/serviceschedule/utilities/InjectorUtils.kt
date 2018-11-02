package com.panwenliang2008.serviceschedule.utilities

import android.content.Context
import com.panwenliang2008.serviceschedule.data.local.db.AppDatabase
import com.panwenliang2008.serviceschedule.data.local.db.Repository.ScheduleRepository

object InjectorUtils {
    private fun getScheduleRepository(context: Context): ScheduleRepository {
        return ScheduleRepository.getInstance(AppDatabase.getInstance(context).scheduleDao())
    }
}