package vn.edu.uit.managementforstudents.ui.fragments.intro.forgot_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentForgotPasswordBinding
import vn.edu.uit.managementforstudents.databinding.FragmentResetPasswordBinding

class ForgotPasswordFragment :Fragment(),ForgotListener{
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
        nav_host_fragment.findNavController().navigate(R.id.action_forgotPasswordFragment_to_resetPasswordFragment)
        Toast.makeText(activity!!,"zoo đổi mk", Toast.LENGTH_LONG).show()

    }
}