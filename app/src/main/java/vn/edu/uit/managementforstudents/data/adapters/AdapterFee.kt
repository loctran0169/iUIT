package vn.edu.uit.managementforstudents.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R

class AdapterFee : RecyclerView.Adapter<AdapterFee.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_fee, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position % 2 != 0) {
            holder.tvPaid.visibility = View.VISIBLE
            holder.tvNoPaid.visibility = View.GONE
        } else {
            holder.tvPaid.visibility = View.GONE
            holder.tvNoPaid.visibility = View.VISIBLE
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPaid = view.findViewById<TextView>(R.id.tvPaid)
        val tvNoPaid = view.findViewById<TextView>(R.id.tvNoPaid)
    }
}