package vn.edu.uit.managementforstudents.ui.fragments.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vn.edu.uit.managementforstudents.databinding.FragmentAccountBinding
import vn.edu.uit.managementforstudents.ui.dialogs.DiaLogEditAccount

class AccountFragment : Fragment(), AccountListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAccountBinding.inflate(inflater, container, false)
        binding.listener = this@AccountFragment
        binding.lifecycleOwner = this@AccountFragment
        return binding.root
    }

    override fun onEditPressed(view: View) {
        DiaLogEditAccount(context!!).show(childFragmentManager, "Edit Account")
    }

    override fun onLogoutPressed(view: View) {

    }
}