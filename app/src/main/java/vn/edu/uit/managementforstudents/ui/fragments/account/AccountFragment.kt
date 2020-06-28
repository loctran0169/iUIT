package vn.edu.uit.managementforstudents.ui.fragments.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentAccountBinding
import vn.edu.uit.managementforstudents.ui.MainActivity
import vn.edu.uit.managementforstudents.ui.dialogs.changepassword.DialogChangePassword
import vn.edu.uit.managementforstudents.ui.dialogs.fee.DialogFee
import vn.edu.uit.managementforstudents.ui.dialogs.score.DialogScore

class AccountFragment : Fragment(), AccountListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAccountBinding.inflate(inflater, container, false)
        binding.listener = this@AccountFragment
        binding.lifecycleOwner = this@AccountFragment
        return binding.root
    }

    override fun onEditPressed(view: View) {
        (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_editAccountFragment)
    }

    override fun onLogoutPressed(view: View) {
        (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_fragment_intro)
    }

    override fun onChangePasswordPressed(view: View) {
        DialogChangePassword().show(childFragmentManager, "change Password")
    }

    override fun onScoreBoardPressed(view: View) {
        DialogScore().show(childFragmentManager,"Score")
    }

    override fun onFeePressed(view: View) {
        DialogFee().show(childFragmentManager, "Fee")
    }
}