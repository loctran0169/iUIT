package vn.edu.uit.managementforstudents.ui.fragments.schedule

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendar
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter
import com.michalsvec.singlerowcalendar.selection.CalendarSelectionManager
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.item_day_of_week.view.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterPagerSchedule
import java.util.*

class ScheduleFragment : Fragment() {

    lateinit var singleRowCalendar: SingleRowCalendar
    var posSelected = 0
    val dayName = listOf("T2", "T3", "T4", "T5", "T6", "T7", "CN")

    val adapterViewPager: AdapterPagerSchedule by lazy {
        AdapterPagerSchedule(childFragmentManager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager_schedule.adapter = adapterViewPager
        viewPager_schedule.offscreenPageLimit = 7
        viewPager_schedule.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (posSelected != position) {
                    posSelected = position
                    singleRowCalendar.scrollToPosition(position)
                    singleRowCalendar.select(position)
                }
            }

        })

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
                if (!isSelected) return
                if (posSelected != position) {
                    posSelected = position
                    viewPager_schedule.currentItem = position
                }
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

    }
}