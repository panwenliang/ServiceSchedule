package com.panwenliang2008.serviceschedule

import com.panwenliang2008.serviceschedule.base.BaseApplication
import com.panwenliang2008.serviceschedule.di.AndroidModule
import com.panwenliang2008.serviceschedule.di.AppComponent
import com.panwenliang2008.serviceschedule.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.DaggerAppCompatActivity

class MyApp : BaseApplication() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder().androidModule(AndroidModule(this)).build()
        graph.inject(this)
    }
}