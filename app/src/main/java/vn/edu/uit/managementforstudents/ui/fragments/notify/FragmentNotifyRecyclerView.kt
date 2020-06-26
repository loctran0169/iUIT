package vn.edu.uit.managementforstudents.ui.fragments.notify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterNotifyGeneral
import vn.edu.uit.managementforstudents.module.adapters.AdapterNotifyPerson
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel

class FragmentNotifyRecyclerView : Fragment() {

    var isPerson = 0
    private val adapterNotifyPerson: AdapterNotifyPerson by lazy {
        AdapterNotifyPerson(this@FragmentNotifyRecyclerView.context!!, viewModel.listNotifyPerson)
    }

    private val adapterNotifyGeneral: AdapterNotifyGeneral by lazy {
        AdapterNotifyGeneral(this@FragmentNotifyRecyclerView.context!!)
    }

    val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this@FragmentNotifyRecyclerView)
            .get(MainViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bundle = arguments
        if (bundle != null) {
            isPerson = bundle.getInt("POS")
        }
        return LayoutInflater.from(activity!!).inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.run {
            layoutManager = LinearLayoutManager(this@FragmentNotifyRecyclerView.context)
            if (isPerson == 0)
                adapter = adapterNotifyPerson
            else
                adapter = adapterNotifyGeneral
        }
    }
}