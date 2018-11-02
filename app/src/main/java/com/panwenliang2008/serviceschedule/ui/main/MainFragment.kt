package com.panwenliang2008.serviceschedule.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.TimeUtils
import com.blankj.utilcode.util.Utils
import com.panwenliang2008.serviceschedule.R
import com.panwenliang2008.serviceschedule.R.id.tvTimeDate
import com.panwenliang2008.serviceschedule.base.BaseFragment
import com.panwenliang2008.serviceschedule.utilities.InjectorUtils
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.currentTime.observe(this, Observer {
            tvTimeDate.text = it
            btnStartWork.text = it
        })

        btnStartWork.setOnClickListener {

        }
    }
}
