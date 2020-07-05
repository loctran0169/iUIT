package vn.edu.uit.managementforstudents.ui.dialogs.changepassword

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.bottom_sheet_change_password.*
import vn.edu.uit.managementforstudents.databinding.BottomSheetChangePasswordBinding


class DialogChangePassword() : BottomSheetDialogFragment(), DialogChangePasswordListener {

    private var onProcess = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = BottomSheetChangePasswordBinding.inflate(inflater, container, false)
        binding.listener = this@DialogChangePassword
        binding.lifecycleOwner = this@DialogChangePassword
        binding.root.setBackgroundColor(Color.TRANSPARENT)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun TextInputLayout.isValidPassWord(): Boolean {
        return when {
            this.editText!!.text.toString().trim().isEmpty() -> {
                this.helperText = "Không được để trống"
                println("### vào null")
                false
            }
            else -> {
                this.helperText = ""
                true
            }
        }
    }

    private fun comparePassword(new: TextInputLayout, newConfirm: TextInputLayout): Boolean {
        return when {
            new.editText!!.text.toString() != newConfirm.editText!!.text.toString() -> {
                newConfirm.helperText = "Mật khẩu nhập lại không chính xác"
                false
            }
            else -> {
                newConfirm.helperText = ""
                true
            }
        }
    }

    override fun onConfrimPressed(view: View) {
        if (onProcess) return
        if (tvOldPassword.isValidPassWord() && tvNewPassword.isValidPassWord() && tvNewPasswordConfirm.isValidPassWord()) {
            if (comparePassword(tvNewPassword, tvNewPasswordConfirm)) {
                progressChangePassword.visibility = View.VISIBLE
                onProcess = true
                this@DialogChangePassword.isCancelable = false
                object : CountDownTimer(2000, 1250) {
                    override fun onFinish() {
                        Toast.makeText(context, "Đã đổi mật khẩu thành công", Toast.LENGTH_SHORT).show()
                        onProcess = false
                        this@DialogChangePassword.dismiss()
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
            }
        }
    }

}