package com.panwenliang2008.serviceschedule.data.local.db.Schedule

import android.graphics.BitmapFactory
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(scheduleEntityList: List<ScheduleEntity>)

    @Query("SELECT * FROM schedule")
    fun loadAll(): List<ScheduleEntity>

    @Query("SELECT * FROM schedule WHERE name = :name")
    fun getScheduleByName(name: String): Flowable<ScheduleEntity>

    @Query("SELECT * FROM schedule WHERE name = :date")
    fun getScheduleByDate(date: String): Flowable<ScheduleEntity>
}