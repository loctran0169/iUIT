package vn.edu.uit.managementforstudents.ui.fragments.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.michalsvec.singlerowcalendar.utils.DateUtils
import kotlinx.android.synthetic.main.bottom_sheet_fee.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_schedule_pager.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterSubjectMS
import vn.edu.uit.managementforstudents.databinding.FragmentHomeBinding
import vn.edu.uit.managementforstudents.ui.fragments.MainViewModel
import java.util.*

class HomeFragment : Fragment(), HomeListener {
    private val calendar = Calendar.getInstance()
    private val thu = calendar.get(Calendar.DAY_OF_WEEK)
    private val viewModelMain: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
    private val adapterSubject: AdapterSubjectMS by lazy {
        AdapterSubjectMS(requireContext(), mutableListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@HomeFragment
        binding.listener = this@HomeFragment
        return binding.root
    }

    //  @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDate.text =
            "Tháng ${DateUtils.getMonthNumber(calendar.time)}, ${DateUtils.getDayNumber(calendar.time)} "
        tvDay.text = DateUtils.getDayName(calendar.time)
        rcv_subject.run {
            adapter = adapterSubject
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
        }
        viewModelMain.listSchedule.observe(
            this.viewLifecycleOwner,
            androidx.lifecycle.Observer { list ->
                val data = list.find { it.dayName == "T" + thu }
                data?.mocHoc?.let {
                    adapterSubject.updateDate(it)
                }
            })
        viewModelMain.b.observe(
            this.viewLifecycleOwner, androidx.lifecycle.Observer {
                if (it)
                    tv_no_data.visibility=View.VISIBLE
                    progressBarHome.visibility=View.GONE

            }
        )
        view_space.setOnClickListener {
            val alert = AlertDialog.Builder(requireActivity())
            val view: View = LayoutInflater.from(context).inflate(R.layout.dialog_checkin, null)
            val progressBar = view.findViewById<ConstraintLayout>(R.id.layoutProgressBar)
            val main = view.findViewById<ConstraintLayout>(R.id.layoutMain)
            val btnCheckin = view.findViewById<TextView>(R.id.btn_checkin)
            alert.setView(view)
            val dialog = alert.create()
            dialog.setCanceledOnTouchOutside(false)
            dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation_Bottom
            dialog.show()
            btnCheckin.setOnClickListener {
                hideKeyboard(dialog)
                progressBar.visibility = View.VISIBLE
                object : CountDownTimer(2000, 1250) {
                    override fun onFinish() {
                        if (view.findViewById<EditText>(R.id.edit_text_code_verify).text.toString() != "8888") {
                            progressBar.visibility = View.GONE
                            Toast.makeText(context, "Sai mã xác thực", Toast.LENGTH_SHORT).show()
                        } else
                            view.findViewById<ConstraintLayout>(R.id.layoutChecked).visibility =
                                View.VISIBLE
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
            }
            view.findViewById<TextView>(R.id.btn_checked).setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    override fun onResume() {
        // viewModel.loadHome()
        super.onResume()
    }

    fun hideKeyboard(dialog: AlertDialog) {
        val imm =
            dialog.context.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(dialog.currentFocus?.windowToken, 0)
    }
}