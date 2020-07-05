package vn.edu.uit.managementforstudents.module.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.NotifyGeneral
import vn.edu.uit.managementforstudents.module.models.NotifyPerson

class AdapterNotifyGeneral(val context: Context,var list: List<NotifyGeneral>) : RecyclerView.Adapter<AdapterNotifyGeneral.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNotifyGeneral.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_notify_general, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterNotifyGeneral.ViewHolder, position: Int) {
            val p0=list[position]

            holder.title.text=p0.title
            holder.date.text=p0.date
            holder.layout.setOnClickListener{
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(p0.link)
                );
                context.startActivity(browserIntent)
            }
    }
    fun updateDate(item: List<NotifyGeneral>) {
        list = item
        notifyDataSetChanged()
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val title=view.findViewById<TextView>(R.id.tvNameGeneral)
         val date=view.findViewById<TextView>(R.id.tv_modified)
         val layout=view.findViewById<ConstraintLayout>(R.id.layout_notify_general)
    }
}