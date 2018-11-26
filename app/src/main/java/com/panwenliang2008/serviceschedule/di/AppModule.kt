package com.panwenliang2008.serviceschedule.di

import android.app.Application
import androidx.room.Room
import com.panwenliang2008.serviceschedule.constant.AppConstants
import com.panwenliang2008.serviceschedule.data.local.db.AppDatabase
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
//    @Singleton
//    @Provides
//    fun provideGithubService(): GithubService {
//        return Retrofit.Builder()
//            .baseUrl("https://api.github.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
//            .build()
//            .create(GithubService::class.java)
//    }

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppConstants.APP_DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): ScheduleDao {
        return db.scheduleDao()
    }
}
