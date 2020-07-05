package vn.edu.uit.managementforstudents.module.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.jaredrummler.materialspinner.MaterialSpinner
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.MonHoc

class AdapterMonHocLichSu(context: Context, @LayoutRes private val layoutResource: Int, private var monHoc: List<MonHoc>) : MaterialSpinner(context) {

    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: TextView = convertView as TextView?
            ?: LayoutInflater.from(context).inflate(R.layout.item_sub_name, parent, false) as TextView
        view.text = monHoc[position].tenMonHoc
        return view
    }

}