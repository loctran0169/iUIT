package vn.edu.uit.managementforstudents.ui.fragments.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.michalsvec.singlerowcalendar.utils.DateUtils
import kotlinx.android.synthetic.main.fragment_home.*
import vn.edu.uit.managementforstudents.data.adapters.AdapterSubjectMS
import vn.edu.uit.managementforstudents.databinding.FragmentHomeBinding
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel
import java.util.*

class HomeFragment : Fragment(), HomeListener {
    private val calendar = Calendar.getInstance()

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders
            .of(this@HomeFragment)
            .get(MainViewModel::class.java)
    }
    private val adapterSubject: AdapterSubjectMS by lazy {
        AdapterSubjectMS(this@HomeFragment.context!!, viewModel.listSubject)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@HomeFragment
        binding.listener = this@HomeFragment
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDate.text = "Tháng ${DateUtils.getMonthNumber(calendar.time)}, ${DateUtils.getDayNumber(calendar.time)} "
        tvDay.text = DateUtils.getDayName(calendar.time)
        rcv_subject.run {
            adapter = adapterSubject
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
        }
    }

    override fun onNextPressed(view: View) {

    }

    override fun onPrevPressed(view: View) {

    }
}