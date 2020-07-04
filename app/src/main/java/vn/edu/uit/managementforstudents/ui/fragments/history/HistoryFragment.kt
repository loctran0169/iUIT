package vn.edu.uit.managementforstudents.ui.fragments.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupWindow
import android.widget.Spinner
import androidx.appcompat.widget.ListPopupWindow
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentHistoryBinding
import vn.edu.uit.managementforstudents.module.adapters.AdapterHistory
import vn.edu.uit.managementforstudents.module.adapters.AdapterMonHocLichSu
import vn.edu.uit.managementforstudents.module.models.MonHoc
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel
import vn.edu.uit.managementforstudents.utils.extension.avoidDropdownFocus

class HistoryFragment : Fragment() {

    private val viewModelMain: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private val adapterHistory: AdapterHistory by lazy {
        AdapterHistory(requireActivity().supportFragmentManager, mutableListOf())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        println("### create")
        val binding = FragmentHistoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@HistoryFragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_history.run {
            adapter = adapterHistory
            layoutManager = LinearLayoutManager(context)
        }

        viewModelMain.listMonHoc.observe(this.viewLifecycleOwner, Observer {
            spinner_history.setItems(it.map { it.tenMonHoc })
        })

        viewModelMain.listLichSuMonHoc.observe(this.viewLifecycleOwner, Observer {
            adapterHistory.updateData(it)
        })
    }

    override fun onDestroy() {
        println("### destroy")
        super.onDestroy()
    }
}