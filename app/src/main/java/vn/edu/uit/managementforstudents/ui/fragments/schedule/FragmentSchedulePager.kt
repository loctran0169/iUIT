package vn.edu.uit.managementforstudents.ui.fragments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_schedule_pager.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.SpaceItem
import vn.edu.uit.managementforstudents.module.adapters.AdapterShedule

class FragmentSchedulePager(val day: Int) : Fragment() {

    private val adapterMorning: AdapterShedule by lazy {
        AdapterShedule()
    }
    private val adapterAfterNoon: AdapterShedule by lazy {
        AdapterShedule()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_schedule_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (day) {
            0 -> {

            }
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

            }
            5 -> {

            }
            6 -> {

            }

        }
        rcv_morning.run {
            adapter = adapterMorning
            layoutManager = LinearLayoutManager(this@FragmentSchedulePager.context)
            addItemDecoration(SpaceItem(4))
        }
        rcv_afternoon.run {
            adapter = adapterAfterNoon
            layoutManager = LinearLayoutManager(this@FragmentSchedulePager.context)
            addItemDecoration(SpaceItem(4))
        }
    }
}