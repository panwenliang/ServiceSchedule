package com.panwenliang2008.serviceschedule.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleDao
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleEntity

@Database(entities = [(ScheduleEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
}