package com.panwenliang2008.serviceschedule.di

import com.panwenliang2008.serviceschedule.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeRepoFragment(): MainFragment
}
