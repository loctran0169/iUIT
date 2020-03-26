package vn.edu.uit.managementforstudents.ui.fragments.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentIntroBinding

class IntroFragment : Fragment(), IntroListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentIntroBinding.inflate(inflater, container, false)
        binding.listener = this@IntroFragment
        binding.lifecycleOwner = this@IntroFragment
        return binding.root
    }

    override fun onLoginPressed(view: View) {
        nav_host_fragment.findNavController().navigate(R.id.action_fragment_intro_to_loginFragment)
    }

    override fun onForgotPassword(view: View) {
        nav_host_fragment.findNavController().navigate(R.id.action_fragment_intro_to_forgotPasswordFragment)
        Toast.makeText(activity!!,"zoo quên pass",Toast.LENGTH_LONG).show()
    }

    override fun onRegisterPressed(view: View) {

    }
}