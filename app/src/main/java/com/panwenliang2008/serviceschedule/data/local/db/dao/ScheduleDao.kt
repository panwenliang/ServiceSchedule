package com.panwenliang2008.serviceschedule.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.panwenliang2008.serviceschedule.data.local.db.entity.ScheduleEntity

@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(scheduleEntity: ScheduleEntity)
}