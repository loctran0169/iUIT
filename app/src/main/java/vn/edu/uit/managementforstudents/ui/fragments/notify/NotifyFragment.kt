package vn.edu.uit.managementforstudents.ui.fragments.notify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vn.edu.uit.managementforstudents.databinding.FragmentNotifyBinding

class NotifyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentNotifyBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@NotifyFragment
        return binding.root
    }
}