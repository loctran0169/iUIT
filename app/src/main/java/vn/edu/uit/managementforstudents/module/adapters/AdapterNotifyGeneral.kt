package vn.edu.uit.managementforstudents.module.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
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
        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://quiznhe.com/tung-bi-chi-trich-ve-phong-cach-an-mac-bat-ngo-nhan-duoc-loi-khen-ve-gu-thoi-trang-cua-minh-607941.html?utm_source=Trungtd&utm_medium=Trungtd&utm_campaign=Vungdk&fbclid=IwAR1KRvIwM-YuKWZ39BYECL0Z0nUVR9LhLSj7m72zz3pPzYYmpobCVruNZ6E"));
            context.startActivity(browserIntent)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}