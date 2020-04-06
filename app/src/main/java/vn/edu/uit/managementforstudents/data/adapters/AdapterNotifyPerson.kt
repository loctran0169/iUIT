package vn.edu.uit.managementforstudents.data.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.data.models.NotifyPerson

class AdapterNotifyPerson(val context: Context, var list: List<NotifyPerson>) : RecyclerView.Adapter<AdapterNotifyPerson.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNotifyPerson.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_notify_person, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterNotifyPerson.ViewHolder, position: Int) {
        if (position % 2 != 0)
            holder.image.isSelected = true
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageButton>(R.id.img_isRead)
    }
}