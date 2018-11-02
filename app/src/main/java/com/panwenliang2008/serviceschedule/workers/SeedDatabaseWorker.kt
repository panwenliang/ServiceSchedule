package com.panwenliang2008.serviceschedule.workers

import android.content.Context
import android.util.JsonReader
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.panwenliang2008.serviceschedule.data.local.db.AppDatabase
import com.panwenliang2008.serviceschedule.data.local.db.entity.ScheduleEntity

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}