package com.panwenliang2008.serviceschedule.di

import android.content.Context
import androidx.room.Room
import com.panwenliang2008.serviceschedule.MyApp
import com.panwenliang2008.serviceschedule.constant.AppConstants
import com.panwenliang2008.serviceschedule.data.local.db.AppDatabase
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleRepo
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val myApp: MyApp) {

    @Provides
    @Singleton
    @ForApplication
    fun provideAppContext(): Context = myApp

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @Singleton
    internal fun provideOptionsRepoHelper(appDatabase: AppDatabase): ScheduleRepo = ScheduleRepository(appDatabase.scheduleDao())
}