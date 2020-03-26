package vn.edu.uit.managementforstudents.ui.fragments.intro.resetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentResetPasswordBinding

class ResetPasswordFragment : Fragment(),ResetListener{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        binding.listener = this@ResetPasswordFragment
        binding.lifecycleOwner = this@ResetPasswordFragment
        return binding.root
    }

    override fun onBackPressed(view: View) {
        activity?.onBackPressed()
    }

    override fun onAcceptPressed(view: View) {
        findNavController().navigate(R.id.action_resetPasswordFragment_to_fragment_intro)
        Toast.makeText(activity!!,"quay lại màn hình chính", Toast.LENGTH_LONG).show()
    }
}