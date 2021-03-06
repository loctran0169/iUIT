package vn.edu.uit.managementforstudents.utils.extension

import android.widget.ListPopupWindow
import android.widget.PopupWindow
import android.widget.Spinner

fun Spinner.avoidDropdownFocus() {
    try {
        val listPopup = Spinner::class.java
            .getDeclaredField("mPopup")
            .apply {
                //isAccessible = true

            }
            .get(this)
        if (listPopup is ListPopupWindow) {
            val popup = ListPopupWindow::class.java
                .getDeclaredField("mPopup")
                .apply {
                    //isAccessible = true
                }
                .get(listPopup)
            if (popup is PopupWindow) {
                //popup.isFocusable = false
                popup.height = 200
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}