package vn.edu.uit.managementforstudents.ui.dialogs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_notify_person.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.NotifyPerson

class BaseBottomSheetNotifyPerson(val input: NotifyPerson) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_notify_person, null)
        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_context.text=input.context
        tvTime.text=input.date
        tv_name_teacher.text=input.teacher
        tv_name_khoa.text=input.khoa
        tv_name_sub.text=input.subject
        tv_code_sub.text=input.codeSubject
        tv_room.text=input.phong
        tv_period_start.text=input.period_start
        tv_period_end.text=input.period_end
        tv_day.text=input.modified
        super.onViewCreated(view, savedInstanceState)
    }
}