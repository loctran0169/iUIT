package vn.edu.uit.managementforstudents.ui.fragments.intro.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), LoginListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.listener = this@LoginFragment
        binding.lifecycleOwner = this@LoginFragment
        return binding.root
    }

    override fun onBackPressed(view: View) {
        activity?.onBackPressed()
    }

    override fun onLoginPressed(view: View) {
        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        Toast.makeText(activity!!, "vào main activity", Toast.LENGTH_LONG).show()
    }

    override fun onForgotPassword(view: View) {
        nav_host_fragment.findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        Toast.makeText(activity!!, "vào màn hình quên pass", Toast.LENGTH_LONG).show()
    }

}