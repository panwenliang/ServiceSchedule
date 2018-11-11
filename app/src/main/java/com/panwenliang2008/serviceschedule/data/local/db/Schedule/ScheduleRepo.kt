package com.panwenliang2008.serviceschedule.data.local.db.Schedule

import android.graphics.BitmapFactory
import io.reactivex.Observable

interface ScheduleRepo {
    fun insertSchedule(scheduleEntityList: List<ScheduleEntity>): Observable<Boolean>

    fun loadSchedule(): Observable<List<ScheduleEntity>>
}