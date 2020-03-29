package vn.edu.uit.managementforstudents.ui.fragments.intro

import android.view.View

interface IntroListener {

    fun onLoginPressed(view: View)

    fun onForgotPassword(view: View)

    fun onRegisterPressed(view: View)

    fun showGif()
}