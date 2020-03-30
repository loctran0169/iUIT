package vn.edu.uit.managementforstudents.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_main.*
import vn.edu.uit.managementforstudents.R

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity!!).inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val w = activity?.window
            w?.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        val navController = Navigation.findNavController(activity!!, R.id.frmMain)
        NavigationUI.setupWithNavController(bottom_navigaion_view, navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.fragment_home -> tv_title_tab.text = "Lịch học là gì"
                R.id.fragment_schedule -> tv_title_tab.text = "Thời khóa biểu"
                R.id.fragment_history -> tv_title_tab.text = "Lịch sử"
                R.id.fragment_notify -> tv_title_tab.text = "Thông báo"
                else -> tv_title_tab.text = "Tài khoản"
            }
        }
    }
}