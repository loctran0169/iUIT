package vn.edu.uit.managementforstudents.ui.fragments.account

import android.view.View

interface AccountListener {
    fun onEditPressed(view: View)
    fun onLogoutPressed(view: View)
    fun onChangePasswordPressed(view: View)
    fun onScoreBoardPressed(view :View)
    fun onFeePressed(view: View)
}