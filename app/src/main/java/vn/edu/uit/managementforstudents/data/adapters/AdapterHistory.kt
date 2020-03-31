package vn.edu.uit.managementforstudents.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import vn.edu.uit.managementforstudents.R

class AdapterHistory : RecyclerView.Adapter<AdapterHistory.ViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHistory.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: AdapterHistory.ViewHolder, position: Int) {
        if (position % 2 != 0) {
            holder.tvEnjoy.visibility = View.VISIBLE
            holder.tvLeave.visibility = View.GONE
        } else {
            holder.tvEnjoy.visibility = View.GONE
            holder.tvLeave.visibility = View.VISIBLE
        }
        if (position % 3 == 0) {
            holder.tvProto.text = "Class"
        }
        holder.layout.setOnClickListener {
            val view = LayoutInflater.from(context).inflate(R.layout.item_history, null)
            val dialog = BottomSheetDialog(context)
            dialog.setContentView(view)
            dialog.show()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvEnjoy = view.findViewById<TextView>(R.id.tvEnjoyClass)
        val tvLeave = view.findViewById<TextView>(R.id.tvLeaveClass)
        val tvProto = view.findViewById<TextView>(R.id.lbProto)
        val layout = view.findViewById<ConstraintLayout>(R.id.layout_history)
    }
}