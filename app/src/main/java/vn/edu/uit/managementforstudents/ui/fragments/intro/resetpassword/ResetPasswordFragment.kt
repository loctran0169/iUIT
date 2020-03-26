package vn.edu.uit.managementforstudents.ui.fragments.intro.resetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}