package com.panwenliang2008.serviceschedule.di

import android.content.Context
import com.panwenliang2008.serviceschedule.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val myApp: MyApp) {

    @Provides
    @Singleton
    @ForApplication
    fun provideAppContext(): Context = myApp
}