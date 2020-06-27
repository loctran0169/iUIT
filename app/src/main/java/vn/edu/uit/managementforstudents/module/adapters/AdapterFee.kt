package vn.edu.uit.managementforstudents.module.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.HocPhi
import java.text.DecimalFormat

class AdapterFee(var list: List<HocPhi>) : RecyclerView.Adapter<AdapterFee.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_fee, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p0 = list[position]
        holder.tvName.text = p0.tenHocKy
        holder.tvNumber.text = "Số môn: ${p0.mocHoc.size}"
        holder.tvTC.text = "Số chỉ: ${p0.mocHoc.sumBy { it.TC!! }}"
        holder.tvHocPhi.text = "Học phí: ${DecimalFormat("#,###.##").format(p0.hocPhi)}"
        if (p0.thanhToan == true) {
            holder.tvPaid.visibility = View.VISIBLE
            holder.tvNoPaid.visibility = View.GONE
        } else {
            holder.tvPaid.visibility = View.GONE
            holder.tvNoPaid.visibility = View.VISIBLE
        }
    }

    fun updateData(items: List<HocPhi>) {
        list = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPaid = view.findViewById<TextView>(R.id.tvPaid)
        val tvName = view.findViewById<TextView>(R.id.tvNameTerm)
        val tvNumber = view.findViewById<TextView>(R.id.tvNumberSubTerm)
        val tvTC = view.findViewById<TextView>(R.id.tvNumberTC)
        val tvNoPaid = view.findViewById<TextView>(R.id.tvNoPaid)
        val tvHocPhi = view.findViewById<TextView>(R.id.tvHocPhi)
    }
}