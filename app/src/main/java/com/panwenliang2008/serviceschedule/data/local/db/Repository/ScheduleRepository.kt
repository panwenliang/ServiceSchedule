package com.panwenliang2008.serviceschedule.data.local.db.Repository

import com.panwenliang2008.serviceschedule.data.local.db.dao.ScheduleDao

class ScheduleRepository private constructor(private val scheduleDao: ScheduleDao){

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ScheduleRepository? = null

        fun getInstance(scheduleDao: ScheduleDao) =
            instance ?: synchronized(this) {
                instance ?: ScheduleRepository(scheduleDao).also { instance = it }
            }
    }
}