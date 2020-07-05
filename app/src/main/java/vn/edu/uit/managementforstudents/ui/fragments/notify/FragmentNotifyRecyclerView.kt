package vn.edu.uit.managementforstudents.ui.fragments.notify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterNotifyGeneral
import vn.edu.uit.managementforstudents.module.adapters.AdapterNotifyPerson
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel

class FragmentNotifyRecyclerView : Fragment() {

    var isPerson = 0
    private val viewModelMain: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
    private val adapterNotifyPerson: AdapterNotifyPerson by lazy {
        AdapterNotifyPerson(activity!!.supportFragmentManager,this@FragmentNotifyRecyclerView.requireContext()!!,mutableListOf())
    }

    private val adapterNotifyGeneral: AdapterNotifyGeneral by lazy {
        AdapterNotifyGeneral(this@FragmentNotifyRecyclerView.requireContext()!!,mutableListOf())
    }

    val viewModel: ViewModelNotifyPerson by lazy {
        ViewModelProviders
            .of(requireActivity())
            .get(ViewModelNotifyPerson::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bundle = arguments
        if (bundle != null) {
            isPerson = bundle.getInt("POS")
        }
        return LayoutInflater.from(requireActivity()).inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            if (isPerson == 0)
                adapter = adapterNotifyPerson
            else
                adapter = adapterNotifyGeneral
        }
        viewModel.loadNotifyPerson.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (!it.isNullOrEmpty()) {
                adapterNotifyPerson.updateDate(it)
                // progressBarHome.visibility=View.GONE
            }
        })


        viewModelMain.listNotifyGeneral.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                adapterNotifyGeneral.updateDate(it)
            }
        })


    }
}