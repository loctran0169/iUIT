package vn.edu.uit.managementforstudents.module.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.NotifyPerson
import vn.edu.uit.managementforstudents.ui.dialogs.BaseBottomSheetNotifyPerson

//val childFragment: FragmentManager,
class AdapterNotifyPerson(val childFragment: FragmentManager, val context: Context, var list: List<NotifyPerson>) : RecyclerView.Adapter<AdapterNotifyPerson.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNotifyPerson.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_notify_person, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterNotifyPerson.ViewHolder, position: Int) {
        val p0 = list[position]
        holder.context.text = p0.context
        holder.name_sub.text = p0.subject
        holder.day.text = p0.modified
        holder.time.text = p0.date
        if (p0.isReading)
            holder.image.isSelected = true

        holder.layout.setOnClickListener {
            val base = BaseBottomSheetNotifyPerson(p0)
            holder.image.isSelected = true
            list[position].isReading = true
            base.show(childFragment, "")
        }

    }

    fun updateDate(item: List<NotifyPerson>) {
        list = item
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layout = view.findViewById<ConstraintLayout>(R.id.layout_notify_person)
        val image = view.findViewById<ImageButton>(R.id.img_isRead)
        val context = view.findViewById<TextView>(R.id.tv_context)
        val name_sub = view.findViewById<TextView>(R.id.tv_name_sub)
        val day = view.findViewById<TextView>(R.id.tv_day_end)
        val time = view.findViewById<TextView>(R.id.tv_time_end)
    }
}