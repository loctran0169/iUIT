package vn.edu.uit.managementforstudents.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_main.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    var backTime = 0L
    val sharedPref: SharedPreferences.Editor by lazy {
        context!!.getSharedPreferences("iUIT", Context.MODE_PRIVATE).edit()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@MainFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(activity!!, R.id.frmMain)
        NavigationUI.setupWithNavController(bottom_navigaion_view, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            sharedPref.putBoolean("MAIN", false)
            sharedPref.apply()
            when (destination.id) {
                R.id.fragment_home -> {
                    sharedPref.putBoolean("MAIN", true)
                    sharedPref.apply()
                    this.appBarLayout.setExpanded(true, true)
                    tv_title_tab.text = "Lịch học là gì"
                }
                R.id.fragment_schedule -> {
                    this.appBarLayout.setExpanded(true, true)
                    tv_title_tab.text = "Thời khóa biểu"
                }
                R.id.fragment_history -> {
                    this.appBarLayout.setExpanded(true, true)
                    tv_title_tab.text = "Lịch sử"
                }
                R.id.fragment_notify -> {
                    this.appBarLayout.setExpanded(true, true)
                    tv_title_tab.text = "Thông báo"
                }
                R.id.fragment_account -> {
                    this.appBarLayout.setExpanded(true, true)
                    this.tv_title_tab.text = "Tài khoản"
                }
            }
        }
    }
}