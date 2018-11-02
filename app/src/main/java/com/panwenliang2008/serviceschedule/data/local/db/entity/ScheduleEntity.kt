package com.panwenliang2008.serviceschedule.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "schedule")
data class ScheduleEntity(
    @PrimaryKey @ColumnInfo(name = "id") val scheduleId: String,
    val name: String,
    val date: String,
    val startTime: String,
    val endTime: String
) {

    override fun toString() = name
}