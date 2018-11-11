package com.panwenliang2008.serviceschedule.data.local.db.Schedule

import io.reactivex.Observable
import javax.inject.Inject

class ScheduleRepository @Inject constructor(private val scheduleDao: ScheduleDao) : ScheduleRepo{
    override fun loadSchedule(): Observable<List<ScheduleEntity>>  = Observable.fromCallable { scheduleDao.loadAll() }

    override fun insertSchedule(scheduleEntityList: List<ScheduleEntity>): Observable<Boolean> {
        scheduleDao.insertAll(scheduleEntityList)
        return Observable.just(true)
    }
}