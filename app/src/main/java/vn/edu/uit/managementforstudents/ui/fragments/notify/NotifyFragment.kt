package vn.edu.uit.managementforstudents.ui.fragments.notify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_notify.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterNotifyTab
import vn.edu.uit.managementforstudents.databinding.FragmentNotifyBinding

class NotifyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentNotifyBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@NotifyFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager_notify.adapter = AdapterNotifyTab(childFragmentManager)
        tabLayout_notify.tabMode = TabLayout.MODE_FIXED
        tabLayout_notify.setupWithViewPager(viewPager_notify)

        tabLayout_notify.getTabAt(0)?.icon = resources.getDrawable(R.drawable.ic_private)
        tabLayout_notify.getTabAt(1)?.icon = resources.getDrawable(R.drawable.ic_general)
    }
}