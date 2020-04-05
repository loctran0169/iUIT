package vn.edu.uit.managementforstudents.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import vn.edu.uit.managementforstudents.R

class DiaLogEditAccount(context: Context) : BottomSheetDialogFragment() {

    override fun setupDialog(dialog: Dialog, style: Int) {
        val view: View = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_edit_account, null)
        dialog.setContentView(view)
        (view.parent as View).setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}