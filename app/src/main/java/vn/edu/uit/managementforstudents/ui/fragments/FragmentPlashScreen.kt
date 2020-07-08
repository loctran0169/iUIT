package vn.edu.uit.managementforstudents.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_plashscreen.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentPlashscreenBinding

class FragmentPlashScreen : Fragment() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentPlashscreenBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@FragmentPlashScreen
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        whorlPlashScreen.start()
        Handler().postDelayed({
            findNavController().navigate(R.id.action_fragmentPlashScreen_to_mainFragment)
        }, 3000)
    }
}