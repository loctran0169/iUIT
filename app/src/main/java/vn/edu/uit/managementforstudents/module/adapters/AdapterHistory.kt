package vn.edu.uit.managementforstudents.module.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.ui.dialogs.BaseBottomSheetHistory

class AdapterHistory(val childFragment: FragmentManager) : RecyclerView.Adapter<AdapterHistory.ViewHolder>() {
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
            val base = BaseBottomSheetHistory()
            base.show(childFragment, "")
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvEnjoy = view.findViewById<TextView>(R.id.tvEnjoyClass)
        val tvLeave = view.findViewById<TextView>(R.id.tvLeaveClass)
        val tvProto = view.findViewById<TextView>(R.id.lbProto)
        val layout = view.findViewById<ConstraintLayout>(R.id.layout_history)
    }
}