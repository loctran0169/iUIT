package vn.edu.uit.managementforstudents.module.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.LichSu
import vn.edu.uit.managementforstudents.ui.dialogs.BaseBottomSheetHistory

class AdapterHistory(val childFragment: FragmentManager, var list: List<LichSu>) : RecyclerView.Adapter<AdapterHistory.ViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHistory.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdapterHistory.ViewHolder, position: Int) {
        val p0 = list[position]
        holder.tvName.text = p0.monHoc?.tenMonHoc ?: ""
        holder.tvNameTeacher.text = p0.monHoc?.tenGiaoVien ?: ""
        holder.tvCount.text = "SL: ${p0.siSo}:${p0.soThanhVien}"
        holder.tvTimeStart.text = p0.thoiGianBatDau
        holder.tvTimeEnd.text = p0.thoiGianKetThuc
        if (p0.trangThai!!) {
            holder.tvEnjoy.visibility = View.VISIBLE
            holder.tvLeave.visibility = View.GONE
        } else {
            holder.tvEnjoy.visibility = View.GONE
            holder.tvLeave.visibility = View.VISIBLE
        }
        holder.tvProto.text = p0.phuongThuc
        holder.layout.setOnClickListener {
            val base = BaseBottomSheetHistory()
            base.show(childFragment, "")
        }
    }

    fun updateData(items: List<LichSu>) {
        list = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name_sub_history)
        val tvNameTeacher = view.findViewById<TextView>(R.id.tv_nameTeacher_sub_history)
        val tvCount = view.findViewById<TextView>(R.id.tv_Count_sub_history)
        val tvTimeStart = view.findViewById<TextView>(R.id.tv_timeStart_sub_history)
        val tvTimeEnd = view.findViewById<TextView>(R.id.tv_timeEnd_sub_history)

        val tvEnjoy = view.findViewById<TextView>(R.id.tvEnjoyClass)
        val tvLeave = view.findViewById<TextView>(R.id.tvLeaveClass)
        val tvProto = view.findViewById<TextView>(R.id.lbProto)
        val layout = view.findViewById<ConstraintLayout>(R.id.layout_history)
    }
}