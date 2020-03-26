package vn.edu.uit.managementforstudents.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vn.edu.uit.managementforstudents.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.lifecycleOwner=this@HomeFragment
        return binding.root
    }
}