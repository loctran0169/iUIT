package vn.edu.uit.managementforstudents.ui.fragments.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_account.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentAccountBinding
import vn.edu.uit.managementforstudents.module.models.AVATAR
import vn.edu.uit.managementforstudents.module.models.HOTEN
import vn.edu.uit.managementforstudents.module.models.MysharedPreferences
import vn.edu.uit.managementforstudents.module.models.NOTIFY
import vn.edu.uit.managementforstudents.ui.MainActivity
import vn.edu.uit.managementforstudents.ui.dialogs.changepassword.DialogChangePassword
import vn.edu.uit.managementforstudents.ui.dialogs.fee.DialogFee
import vn.edu.uit.managementforstudents.ui.dialogs.score.DialogScore
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel

class AccountFragment : Fragment(), AccountListener {
    private val sharedPreferences: MysharedPreferences by lazy {
        MysharedPreferences(requireActivity())
    }
    private val viewModelMain: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAccountBinding.inflate(inflater, container, false)
        binding.listener = this@AccountFragment
        binding.lifecycleOwner = this@AccountFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireActivity())
            .load(sharedPreferences.getStringValue(AVATAR))
            .error(R.drawable.ic_camera)
            .into(img_avatar)
        tvName.text = sharedPreferences.getStringValue(HOTEN)
        switchNotify.isChecked = sharedPreferences.getBoolValue(NOTIFY)
        switchNotify.setOnClickListener {
            sharedPreferences.saveBoolean(NOTIFY, switchNotify.isChecked)
        }
    }

    override fun onEditPressed(view: View) {
        (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_editAccountFragment)
    }

    override fun onLogoutPressed(view: View) {
        sharedPreferences.removeAll()
        (activity as MainActivity).findNavController(R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_loginFragment)
    }

    override fun onChangePasswordPressed(view: View) {
        DialogChangePassword().show(childFragmentManager, "change Password")
    }

    override fun onScoreBoardPressed(view: View) {
        DialogScore().show(childFragmentManager, "Score")
    }

    override fun onFeePressed(view: View) {
        DialogFee().show(childFragmentManager, "Fee")
    }
}