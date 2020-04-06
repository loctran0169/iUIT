package vn.edu.uit.managementforstudents.ui.fragments.account_edit

import android.view.View

interface EditAccountListener {
    fun onBackPressed(view: View)
    fun onAcceptPressed(view: View)
    fun onEditPressed(view: View)
}