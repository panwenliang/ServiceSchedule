package com.panwenliang2008.serviceschedule.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.panwenliang2008.serviceschedule.ui.main.MainViewModel
import com.panwenliang2008.serviceschedule.viewmodel.ScheduleViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ScheduleViewModelFactory): ViewModelProvider.Factory
}
