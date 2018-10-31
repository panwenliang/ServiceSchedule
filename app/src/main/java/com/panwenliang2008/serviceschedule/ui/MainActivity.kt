package com.panwenliang2008.serviceschedule.ui

import android.os.Bundle
import com.panwenliang2008.serviceschedule.R
import com.panwenliang2008.serviceschedule.base.BaseActivity
import com.panwenliang2008.serviceschedule.ui.main.MainFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
