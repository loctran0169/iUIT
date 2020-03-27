package vn.edu.uit.managementforstudents.ui.fragments.intro.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), RegisterListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.listener = this@RegisterFragment
        binding.lifecycleOwner = this@RegisterFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onBackPressed(view: View) {
        activity!!.onBackPressed()
    }

    override fun onAcceptPressed(view: View) {
        nav_host_fragment.findNavController().popBackStack()
        nav_host_fragment.findNavController().navigate(R.id.action_fragment_intro_to_loginFragment)
        Toast.makeText(activity!!,"đk xong chuyển qua đăng nhập",Toast.LENGTH_SHORT).show()
    }
}