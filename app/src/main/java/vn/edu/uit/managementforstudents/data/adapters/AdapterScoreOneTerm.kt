package vn.edu.uit.managementforstudents.data.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.data.models.SubjectScore

class AdapterScoreOneTerm(val context: Context) : RecyclerView.Adapter<AdapterScoreOneTerm.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_score_term, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        repeat(7) {
            val dataRow = RowData()
            dataRow.setData(SubjectScore("ENG005", "ENG005.K12.CLC", "9", "9", "9", "9", "9", "9"))
            holder.table.addView(dataRow.getRow())
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val table = view.findViewById<TableLayout>(R.id.tableScore)
    }

    inner class RowData() {
        var rowHead: TableRow = LayoutInflater.from(context).inflate(R.layout.item_score_row, null) as TableRow
        var mamh: TextView
        var tenmh: TextView
        var tc: TextView
        var qt: TextView
        var th: TextView
        var gk: TextView
        var ck: TextView
        var tb: TextView

        init {
            mamh = rowHead.findViewById(R.id.tvMaMH)
            tenmh = rowHead.findViewById(R.id.tvTenMH)
            tc = rowHead.findViewById(R.id.tvTC)
            qt = rowHead.findViewById(R.id.tvQT)
            th = rowHead.findViewById(R.id.tvTH)
            gk = rowHead.findViewById(R.id.tvGK)
            ck = rowHead.findViewById(R.id.tvCK)
            tb = rowHead.findViewById(R.id.tvTB)
        }

        fun setData(score: SubjectScore) {
            mamh.text = score.MaMH
            tenmh.text = score.TenMH
            tc.text = score.TC
            qt.text = score.QT
            th.text = score.TH
            gk.text = score.GK
            ck.text = score.CK
            tb.text = score.TB
        }

        fun getRow(): TableRow {
            return rowHead
        }
    }
}