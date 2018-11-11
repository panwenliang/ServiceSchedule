package com.panwenliang2008.serviceschedule.data.local.db.Schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "schedule")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

    // 氏名
    @ColumnInfo(name = "name")
    val name: String,

    // 出社時間
    @ColumnInfo(name = "start_time")
    val startTime: String,

    // 退社時間
    @ColumnInfo(name = "end_time")
    val endTime: String,

    // 休憩時間
    @ColumnInfo(name = "rest_time")
    val restTime: String
)