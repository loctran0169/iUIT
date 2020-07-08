package vn.edu.uit.managementforstudents.module.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.MonHoc
import vn.edu.uit.managementforstudents.ui.dialogs.BaseBottomSheetNotifyPerson
import vn.edu.uit.managementforstudents.ui.dialogs.BaseBottomSheetSubject

class AdapterShedule(val childFragment: FragmentManager, var list: List<MonHoc>) : RecyclerView.Adapter<AdapterShedule.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterShedule.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdapterShedule.ViewHolder, position: Int) {
        val p0 = list[position]
        holder.number.text = "${position + 1}"
        holder.name.text = p0.tenMonHoc
        holder.start.text = p0.thoiGianBatDau
        holder.end.text = p0.thoiGianKetThuc
        holder.itemView.setOnClickListener {
            val base = BaseBottomSheetSubject(p0)
            base.show(childFragment, "")
        }
    }

    fun updateData(items: List<MonHoc>) {
        list = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val number = view.findViewById<TextView>(R.id.tvNumberSchedule)
        val name = view.findViewById<TextView>(R.id.tvNameSchedule)
        val start = view.findViewById<TextView>(R.id.tvTimeStart)
        val end = view.findViewById<TextView>(R.id.tvTimeEnd)
    }
}