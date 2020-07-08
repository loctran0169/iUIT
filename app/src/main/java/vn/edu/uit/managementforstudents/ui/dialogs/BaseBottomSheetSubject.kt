package vn.edu.uit.managementforstudents.ui.dialogs

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_subject.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.MonHoc

class BaseBottomSheetSubject (val input: MonHoc) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_subject, null)
        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_name_sub.text=input.tenMonHoc
        tv_code_sub.text="Mã lớp: "+input.maLopHoc
        tv_teacher_name.text="GV: "+input.tenGiaoVien
        tv_room.text="Phòng: "+input.tenPhong


        if (input.msTeamCode.equals("")|| input.msTeamCode.isNullOrEmpty() )
        {
            tv_code_msteam.visibility=View.GONE
        }else{
            tv_code_msteam.visibility=View.VISIBLE
            tv_code_msteam.text="Ms Teams: "+input.msTeamCode
        }

        if (input.tenPhong.equals("")|| input.tenPhong.isNullOrEmpty() )
        {
            tv_room.visibility=View.GONE

        }else{
            tv_room.visibility=View.VISIBLE
            tv_room.text="Phòng : "+input.tenPhong
        }
        tv_day_start.text="BĐ: "+input.ngayBatDau
        tv_day_end.text="KT: "+input.ngayKetThuc
        tv_time_start.text=input.thoiGianBatDau
        tv_time_end.text=input.thoiGianKetThuc
        super.onViewCreated(view, savedInstanceState)
    }
}