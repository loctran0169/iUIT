package vn.edu.uit.managementforstudents.ui.fragments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_schedule_pager.*
import vn.edu.uit.managementforstudents.SpaceItem
import vn.edu.uit.managementforstudents.databinding.FragmentSchedulePagerBinding
import vn.edu.uit.managementforstudents.module.adapters.AdapterShedule
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel

class FragmentSchedulePager(val day: String) : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val adapterMorning: AdapterShedule by lazy {
        AdapterShedule(requireActivity().supportFragmentManager,mutableListOf())
    }
    private val adapterAfterNoon: AdapterShedule by lazy {
        AdapterShedule(requireActivity().supportFragmentManager,mutableListOf())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSchedulePagerBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@FragmentSchedulePager
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcv_morning.run {
            adapter = adapterMorning
            layoutManager = LinearLayoutManager(this@FragmentSchedulePager.context)
            addItemDecoration(SpaceItem(4))
        }
        rcv_afternoon.run {
            adapter = adapterAfterNoon
            layoutManager = LinearLayoutManager(this@FragmentSchedulePager.context)
            addItemDecoration(SpaceItem(4))
        }
        viewModel.listSchedule.observe(this.viewLifecycleOwner, Observer { list ->
            val data = list.find { it.dayName == day }
            data?.mocHoc?.filter { it.isMorning == true }?.let {
                adapterMorning.updateData(it)
                if (it.isEmpty())
                    tvEmptyMorning.visibility = View.GONE
                else
                    tvEmptyMorning.visibility = View.VISIBLE
            }
            data?.mocHoc?.filter { it.isMorning == false }?.let {
                adapterAfterNoon.updateData(it)
                if (it.isEmpty())
                    tvEmptyEvening.visibility = View.GONE
                else
                    tvEmptyEvening.visibility = View.VISIBLE
            }
        })
    }
}