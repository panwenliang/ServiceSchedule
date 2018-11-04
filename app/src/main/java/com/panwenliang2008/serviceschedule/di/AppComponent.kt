package com.panwenliang2008.serviceschedule.di

import com.panwenliang2008.serviceschedule.MyApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class])
interface AppComponent {

    fun inject(myApp: MyApp)
}