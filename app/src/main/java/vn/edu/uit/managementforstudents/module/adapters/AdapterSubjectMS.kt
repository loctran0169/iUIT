package vn.edu.uit.managementforstudents.module.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.MonHoc
import java.text.SimpleDateFormat
import java.util.*

class AdapterSubjectMS(val context: Context, var list: List<MonHoc>) :
    RecyclerView.Adapter<AdapterSubjectMS.ViewHolder>() {
    private val calendar = Calendar.getInstance()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item_calendar_day, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p0 = list[position]
        holder.subjectName.text = p0.tenMonHoc
        holder.teacherName.text = "GV: " + p0.tenGiaoVien
        if (p0.msTeamCode.equals("") || p0.msTeamCode.isNullOrEmpty()) {
            holder.live.isSelected = true
            holder.teamCode.visibility = View.GONE
        } else {
            holder.live.isSelected = false
            holder.teamCode.visibility = View.VISIBLE
            holder.teamCode.text = "MS Teams: " + p0.msTeamCode
            holder.layout.setOnClickListener {
                val sendIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://teams.microsoft.com/l/team/19%3a387635b906bb4ffe823d737f4eb24368%40thread.tacv2/conversations?groupId=56c72d02-692d-4a19-bafd-9642c96dc657&tenantId=2dff09ac-2b3b-4182-9953-2b548e0d0b39")
                )
                if (sendIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(sendIntent)
                }
            }
        }

        if (p0.tenPhong.equals("") || p0.tenPhong.isNullOrEmpty()) {
            holder.room.visibility = View.GONE

        } else {
            holder.room.visibility = View.VISIBLE
            holder.room.text = "Phòng : " + p0.tenPhong
        }
        holder.timeStart.text = p0.thoiGianBatDau
        holder.timeEnd.text = p0.thoiGianKetThuc
        holder.dayStart.text = "BĐ: " + p0.ngayBatDau
        holder.dayEnd.text = "KT:  " + p0.ngayKetThuc
        holder.subcode.text = "Mã lớp: " + p0.maLopHoc
    }

    fun updateDate(item: List<MonHoc>) {
        list = item
        notifyDataSetChanged()
    }

    fun subNow(): MonHoc? {
        list.forEach {
            var tgbd = getHourMi(it.thoiGianBatDau.toString())
            var tgkt = getHourMi(it.thoiGianKetThuc.toString())
            if (compareDate(tgbd)>0 && compareDate(tgkt)<0)
                return it
        }
        return null
    }

    fun compareDate(list: List<Int>): Int {
        if (calendar.get(Calendar.HOUR_OF_DAY)-3 > list[0]) {
            return 1
        } else if (calendar.get(Calendar.HOUR_OF_DAY)-3 < list[0]) {
            return -1
        } else {
            if (calendar.get(Calendar.MINUTE) > list[1])
                return 1
            else if (calendar.get(Calendar.MINUTE) < list[1])
                return -1
            else
                return 0
        }
    }

    fun getHourMi(input: String): List<Int> {
        var list: List<Int>
        var h: Int
        var m: Int
        m = input.substring(input.length - 2, input.length).toInt()
        if (input.length == 5)
            h = input.substring(0, 2).toInt()
        else h = input.substring(0, 1).toInt()

        list = listOf(h, m)
        return list

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var subjectName = view.findViewById<TextView>(R.id.tv_name_sub)
        var teacherName = view.findViewById<TextView>(R.id.tv_teacher_name)
        var teamCode = view.findViewById<TextView>(R.id.tv_code_msteam)
        var room = view.findViewById<TextView>(R.id.tv_room)
        var timeStart = view.findViewById<TextView>(R.id.tv_time_start)
        var timeEnd = view.findViewById<TextView>(R.id.tv_time_end)
        var dayStart = view.findViewById<TextView>(R.id.tv_day_start)
        var dayEnd = view.findViewById<TextView>(R.id.tv_day_end)
        val layout = view.findViewById<ConstraintLayout>(R.id.layout_info_subject)
        var live = view.findViewById<ImageButton>(R.id.img_live)
        var subcode = view.findViewById<TextView>(R.id.tv_code_sub)
    }
}