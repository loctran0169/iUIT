package vn.edu.uit.managementforstudents.ui.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.date.dayOfMonth
import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendar
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter
import com.michalsvec.singlerowcalendar.selection.CalendarSelectionManager
import com.michalsvec.singlerowcalendar.utils.DateUtils
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_day_of_week.view.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.data.adapters.AdapterSubjectMS
import vn.edu.uit.managementforstudents.databinding.FragmentHomeBinding
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel
import java.util.*

class HomeFragment : Fragment(), HomeListener {
    private val calendar = Calendar.getInstance()
    private var currentMonth = 0
    private var currentYear = 0
    private val currentDay = calendar.dayOfMonth
    lateinit var singleRowCalendar: SingleRowCalendar
    val viewModel: MainViewModel by lazy {
        ViewModelProviders
            .of(this@HomeFragment)
            .get(MainViewModel::class.java)
    }
    val adapterSubject: AdapterSubjectMS by lazy {
        AdapterSubjectMS(this@HomeFragment.context!!, viewModel.listSubject)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@HomeFragment
        binding.listener = this@HomeFragment
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myCalendarViewManager = object : CalendarViewManager {
            override fun setCalendarViewResourceId(
                position: Int,
                date: Date,
                isSelected: Boolean
            ): Int {
                val cal = Calendar.getInstance()
                cal.time = date

                return when {
                    isSelected -> R.layout.item_day_of_week_selected
                    else -> R.layout.item_day_of_week
                }
            }

            override fun bindDataToCalendarView(
                holder: SingleRowCalendarAdapter.CalendarViewHolder,
                date: Date,
                position: Int,
                isSelected: Boolean
            ) {
                holder.itemView.tv_date_calendar_item.text = DateUtils.getDayNumber(date)
                holder.itemView.tv_day_calendar_item.text = DateUtils.getDay3LettersName(date)
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
                tvDate.text = "${DateUtils.getMonthName(date).capitalize()}, ${DateUtils.getDayNumber(date)} "
                tvDay.text = DateUtils.getDayName(date)
                super.whenSelectionChanged(isSelected, position, date)
            }
        }
        tvDate.text = "Tháng ${DateUtils.getMonthNumber(calendar.time)}, ${DateUtils.getDayNumber(calendar.time)} "
        tvDay.text = DateUtils.getDayName(calendar.time)
        singleRowCalendar = main_single_row_calendar.apply {
            calendarViewManager = myCalendarViewManager
            calendarChangesObserver = myCalendarChangesObserver
            calendarSelectionManager = mySelectionManager
            setDates(getFutureDatesOfCurrentMonth())
            init()
        }
        setCurrentDay(currentDay)
        rcv_subject.run {
            adapter = adapterSubject
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
        }
    }

    private fun getDatesOfNextMonth(): List<Date> {
        currentMonth++
        if (currentMonth == 12) {
            calendar.set(Calendar.YEAR, calendar[Calendar.YEAR] + 1)
            currentMonth = 0 // 0 == january
        }
        return getDates(mutableListOf())
    }

    private fun getDatesOfPreviousMonth(): List<Date> {
        currentMonth--
        if (currentMonth == -1) {
            calendar.set(Calendar.YEAR, calendar[Calendar.YEAR] - 1)
            currentMonth = 11 // 11 == december
        }
        return getDates(mutableListOf())
    }

    private fun getFutureDatesOfCurrentMonth(): List<Date> {
        currentMonth = calendar[Calendar.MONTH]
        currentYear = calendar[Calendar.YEAR]
        return getDates(mutableListOf())
    }

    private fun getDates(list: MutableList<Date>): List<Date> {
        calendar.set(Calendar.MONTH, currentMonth)
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        list.add(calendar.time)
        while (currentMonth == calendar[Calendar.MONTH]) {
            calendar.add(Calendar.DATE, +1)
            if (calendar[Calendar.MONTH] == currentMonth)
                list.add(calendar.time)
        }
        calendar.add(Calendar.DATE, -1)
        return list
    }

    override fun onNextPressed(view: View) {
        singleRowCalendar.setDates(getDatesOfNextMonth())
        singleRowCalendar.scrollToPosition(0)
        tvCurrentMonth.text = " ${currentMonth + 1}"
        tvCurrentYear.text = "${calendar[Calendar.YEAR]}"
    }

    override fun onPrevPressed(view: View) {
        singleRowCalendar.setDates(getDatesOfPreviousMonth())
        singleRowCalendar.scrollToPosition(0)
        tvCurrentMonth.text = " ${currentMonth + 1}"
        tvCurrentYear.text = "${calendar[Calendar.YEAR]}"
    }

    private fun setCurrentDay(index: Int) {
        singleRowCalendar.select(index - 1)
        singleRowCalendar.scrollToPosition(index - 1)
    }
}