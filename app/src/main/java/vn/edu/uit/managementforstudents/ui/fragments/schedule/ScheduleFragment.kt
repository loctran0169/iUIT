package vn.edu.uit.managementforstudents.ui.fragments.schedule

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendar
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter
import com.michalsvec.singlerowcalendar.selection.CalendarSelectionManager
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.item_day_of_week.view.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.SpaceItem
import vn.edu.uit.managementforstudents.module.adapters.AdapterShedule
import java.util.*

class ScheduleFragment : Fragment() {

    lateinit var singleRowCalendar: SingleRowCalendar
    val dayName = listOf("T2", "T3", "T4", "T5", "T6", "T7", "CN")

    private val adapterMorning: AdapterShedule by lazy {
        AdapterShedule()
    }
    private val adapterAfterNoon: AdapterShedule by lazy {
        AdapterShedule()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myCalendarViewManager = object : CalendarViewManager {
            override fun setCalendarViewResourceId(
                position: Int,
                date: Date,
                isSelected: Boolean
            ): Int {
                return when (!isSelected) {
                    true -> R.layout.item_day_of_week
                    else -> R.layout.item_day_of_week_selected
                }
            }

            override fun bindDataToCalendarView(
                holder: SingleRowCalendarAdapter.CalendarViewHolder,
                date: Date,
                position: Int,
                isSelected: Boolean
            ) {
                holder.itemView.tv_date_calendar_item.text = dayName[position]
                if (position % 3 != 0)
                    holder.itemView.viewHaveSub.visibility = View.GONE
            }
        }
        val mySelectionManager = object : CalendarSelectionManager {
            override fun canBeItemSelected(position: Int, date: Date): Boolean {
                return true
            }
        }

        val myCalendarChangesObserver = object : CalendarChangesObserver {
            @SuppressLint("SetTextI18n")
            override fun whenSelectionChanged(isSelected: Boolean, position: Int, date: Date) {
                super.whenSelectionChanged(isSelected, position, date)
            }
        }
        singleRowCalendar = main_single_row_calendar.apply {
            calendarViewManager = myCalendarViewManager
            calendarChangesObserver = myCalendarChangesObserver
            calendarSelectionManager = mySelectionManager
            futureDaysCount = 6
            init()
        }
        singleRowCalendar.select(0)

        rcv_morning.run {
            adapter = adapterMorning
            layoutManager = LinearLayoutManager(this@ScheduleFragment.context)
            addItemDecoration(SpaceItem(4))
        }
        rcv_afternoon.run {
            adapter = adapterAfterNoon
            layoutManager = LinearLayoutManager(this@ScheduleFragment.context)
            addItemDecoration(SpaceItem(4))
        }
    }
}