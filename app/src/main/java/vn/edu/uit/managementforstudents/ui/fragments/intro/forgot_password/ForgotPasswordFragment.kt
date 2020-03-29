package vn.edu.uit.managementforstudents.ui.fragments.intro.forgot_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import vn.edu.uit.managementforstudents.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment(), ForgotListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        binding.listener = this@ForgotPasswordFragment
        binding.lifecycleOwner = this@ForgotPasswordFragment
        return binding.root
    }

    override fun onBackPressed(view: View) {
        activity?.onBackPressed()
    }

    override fun onAcceptPressed(view: View) {
        activity!!.onBackPressed()
        Toast.makeText(activity!!, "Đã gửi tới mail của m", Toast.LENGTH_LONG).show()
    }
}