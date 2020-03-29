package vn.edu.uit.managementforstudents.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R

class AdapterNotifyGeneral(val context: Context) : RecyclerView.Adapter<AdapterNotifyGeneral.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNotifyGeneral.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_notify_general, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: AdapterNotifyGeneral.ViewHolder, position: Int) {

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}