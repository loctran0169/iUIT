package vn.edu.uit.managementforstudents.ui.fragments.history

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_history.*
import vn.edu.uit.managementforstudents.databinding.FragmentHistoryBinding
import vn.edu.uit.managementforstudents.module.adapters.AdapterHistory
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel

class HistoryFragment : Fragment() {

    private var isLoadingHistory = false
    private var idSelectSpinner = 0
    private val viewModelMain: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private val adapterHistory: AdapterHistory by lazy {
        AdapterHistory(requireActivity().supportFragmentManager, mutableListOf())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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
            if (it != null) {
                adapterHistory.updateData(it)
                progressBarHistory.visibility = View.INVISIBLE
                isLoadingHistory = false
                freshHistory.isRefreshing = false
            }
        })
        viewModelMain.loadMoreHis.observe(this.viewLifecycleOwner, Observer {
            if (it.end - it.start > 0) {
                adapterHistory.loadMore(it.start + 1, it.end)
                isLoadingHistory = false
                freshHistory.isRefreshing = false
            }
        })
        spinner_history.setOnItemSelectedListener { view, position, id, item ->
            idSelectSpinner = position
            isLoadingHistory = true
            progressBarHistory.visibility = View.VISIBLE
            viewModelMain.itemsHis.clear()
            adapterHistory.notifyDataSetChanged()
            viewModelMain.loadLichSuMonHoc(viewModelMain.listMonHoc.value?.get(idSelectSpinner)?.maLopHoc)
        }
        freshHistory.setOnRefreshListener {
            isLoadingHistory = true
            progressBarHistory.visibility = View.VISIBLE
            viewModelMain.itemsHis.clear()
            adapterHistory.notifyDataSetChanged()
            viewModelMain.loadLichSuMonHoc(viewModelMain.listMonHoc.value?.get(idSelectSpinner)?.maLopHoc)
        }
        initScrollListener()
    }

    private fun initScrollListener() {
        rcv_history.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @SuppressLint("CheckResult")
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager = recyclerView.layoutManager as LinearLayoutManager
                if (!isLoadingHistory && manager.findLastVisibleItemPosition() >= viewModelMain.listLichSuMonHoc.value!!.size - 5 && viewModelMain.itemsHis.size >= 20) {
                    isLoadingHistory = true
                    viewModelMain.loadLichSuMonHoc(viewModelMain.listMonHoc.value?.get(idSelectSpinner)?.maLopHoc)
                }
            }
        })
    }
}
