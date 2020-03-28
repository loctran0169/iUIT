package vn.edu.uit.managementforstudents.data.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.data.Model.Subject

class AdapterSubjectMS(val context: Context, var list: List<Subject>) : RecyclerView.Adapter<AdapterSubjectMS.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_calendar_day, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (list.isNullOrEmpty()) 0 else list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val p0 = list[position]
//        holder.subjectName.text = p0.subjectName
//        holder.teacherName.text = p0.subjectName
//        holder.teamCode.text = p0.subjectName
//        holder.timeStart.text = p0.subjectName
//        holder.timeEnd.text = p0.subjectName
//        holder.dayStart.text = p0.subjectName
//        holder.dayEnd.text = p0.subjectName
        holder.layout.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://teams.microsoft.com/l/team/19%3a41ee98b7b3ee4b31b77623552f24b7bb%40thread.tacv2/conversations?groupId=b60babd1-af10-4929-a1d6-07e75545fb26&tenantId=2dff09ac-2b3b-4182-9953-2b548e0d0b39"))
            if (sendIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(sendIntent)
            }
        }
    }

    fun updateDate(item: List<Subject>) {
        list = item
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var subjectName = view.findViewById<TextView>(R.id.tv_name_sub)
        var teacherName = view.findViewById<TextView>(R.id.tv_teacher_name)
        var teamCode = view.findViewById<TextView>(R.id.tv_code_msteam)
        var timeStart = view.findViewById<TextView>(R.id.tv_time_start)
        var timeEnd = view.findViewById<TextView>(R.id.tv_time_end)
        var dayStart = view.findViewById<TextView>(R.id.tv_day_start)
        var dayEnd = view.findViewById<TextView>(R.id.tv_day_end)
        val layout = view.findViewById<ConstraintLayout>(R.id.layout_info_subject)
    }
}