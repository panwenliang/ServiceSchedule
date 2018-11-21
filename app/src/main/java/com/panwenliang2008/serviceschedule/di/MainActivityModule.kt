package com.panwenliang2008.serviceschedule.di

import com.panwenliang2008.serviceschedule.di.FragmentBuildersModule
import com.panwenliang2008.serviceschedule.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
