package vn.edu.uit.managementforstudents.module.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import vn.edu.uit.managementforstudents.ui.fragments.schedule.FragmentSchedulePager

class AdapterPagerSchedule(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return FragmentSchedulePager(getStringDay(position))
    }

    override fun getCount(): Int {
        return 7
    }

    private fun getStringDay(position: Int): String {
        return when (position) {
            0 -> "T2"
            1 -> "T3"
            2 -> "T4"
            3 -> "T5"
            4 -> "T6"
            5 -> "T7"
            else -> "CN"
        }
    }
}