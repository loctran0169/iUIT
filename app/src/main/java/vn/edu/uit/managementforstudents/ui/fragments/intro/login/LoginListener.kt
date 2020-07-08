package vn.edu.uit.managementforstudents.ui.fragments.intro.login

import android.view.View

interface LoginListener {
    fun onLoginPressed(view: View)
    fun onForgotPassword(view: View)
    fun onHideKeyBoardPress(view: View)
}