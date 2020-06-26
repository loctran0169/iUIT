package vn.edu.uit.managementforstudents.ui.fragments.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterHistory
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel

class HistoryFragment : Fragment() {
    private val adapterHistory: AdapterHistory by lazy {
        AdapterHistory(activity!!.supportFragmentManager)
    }
    val viewModel: MainViewModel by lazy {
        ViewModelProviders
            .of(activity!!)
            .get(MainViewModel::class.java)
    }

    private val spinnerAdapterHistory: ArrayAdapter<String> by lazy {
        ArrayAdapter(activity!!, R.layout.item_sub_name, viewModel.listName.toTypedArray())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinnerAdapterHistory.setDropDownViewResource(R.layout.item_sub_name_dropdown)
        spinner_history.adapter = spinnerAdapterHistory

        rcv_history.run {
            adapter = adapterHistory
            layoutManager = LinearLayoutManager(context)
        }

    }
}