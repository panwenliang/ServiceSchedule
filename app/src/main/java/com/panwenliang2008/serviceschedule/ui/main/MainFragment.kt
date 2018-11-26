package com.panwenliang2008.serviceschedule.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.blankj.utilcode.util.LogUtils
import com.panwenliang2008.serviceschedule.R
import com.panwenliang2008.serviceschedule.base.BaseFragment
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleEntity
import com.panwenliang2008.serviceschedule.di.Injectable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject


class MainFragment : BaseFragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private val disposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.currentTime.observe(this, Observer {
            tvTimeDate.text = it
            btnStartWork.text = it
        })

        disposable.add(viewModel.getSchedulByName("testName")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                LogUtils.i("fffff")
            }, { error ->
                LogUtils.e("xxxxx", error)
            })
        )

        btnStartWork.setOnClickListener {
            disposable.add(viewModel.insert()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    LogUtils.i("fffff")
                }, { error ->
                    LogUtils.e("xxxxx", error)
                })
            )
        }
    }
}
