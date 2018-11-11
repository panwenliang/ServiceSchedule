package com.panwenliang2008.serviceschedule.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}