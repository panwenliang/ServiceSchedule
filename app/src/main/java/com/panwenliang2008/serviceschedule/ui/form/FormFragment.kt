package com.panwenliang2008.serviceschedule.ui.form

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter.base.BaseQuickAdapter

import com.panwenliang2008.serviceschedule.R
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.form_fragment.*
import kotlinx.android.synthetic.main.form_item.*
import javax.inject.Inject

class FormFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var homeAdapter = FormListAdapter(R.layout.form_item, null)
    private val disposable = CompositeDisposable()

    companion object {
        fun newInstance() = FormFragment()
    }

    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initRecyclerView()
        viewModel = ViewModelProviders.of(this).get(FormViewModel::class.java)
        // TODO: Use the ViewModel

        disposable.add(viewModel.getSchedulByDate("2018")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                homeAdapter.addData(it)
            }, {

            }))
    }

    private fun initView() {
        tvDate.setText(R.string.form_date)
        tvStartTime.setText(R.string.form_start_time)
        tvEndTime.setText(R.string.form_end_time)
        tvRestTime.setText(R.string.form_rest_time)
        tvWorkTime.setText(R.string.form_work_time)
        tvNote.setText(R.string.form_note)
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)

        homeAdapter.openLoadAnimation()
        homeAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { _, _, position ->
            ToastUtils.showLong(homeAdapter.getItem(position)!!.name)
        }
        homeAdapter.notifyDataSetChanged()
        recyclerView.adapter = homeAdapter
    }
}
