package vn.edu.uit.managementforstudents.module.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import vn.edu.uit.managementforstudents.ui.fragments.notify.FragmentNotifyRecyclerView

class AdapterNotifyTab(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        val fragment = FragmentNotifyRecyclerView()
        val bundle= Bundle()
        bundle.putInt("POS",position)
        fragment.arguments=bundle
        return fragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) "Nghĩ - Bù" else "Chung"
    }
}