package com.panwenliang2008.serviceschedule.ui.form

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.panwenliang2008.serviceschedule.R
import com.panwenliang2008.serviceschedule.data.local.db.Schedule.ScheduleEntity

class FormListAdapter(layoutResId: Int, data: List<ScheduleEntity>?) :
    BaseQuickAdapter<ScheduleEntity, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: ScheduleEntity?) {
        helper?.setText(R.id.tvStartTime, item?.startTime)
        helper?.setText(R.id.tvEndTime, item?.endTime)
    }
}