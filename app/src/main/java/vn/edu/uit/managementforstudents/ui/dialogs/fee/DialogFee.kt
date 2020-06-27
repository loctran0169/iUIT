package vn.edu.uit.managementforstudents.ui.dialogs.fee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_fee.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterFee

class DialogFee : BottomSheetDialogFragment() {
    val viewModel: ViewModelFee by lazy {
        ViewModelProviders
            .of(requireActivity())
            .get(ViewModelFee::class.java)
    }

    private val adapterFee: AdapterFee by lazy {
        AdapterFee(mutableListOf())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.bottom_sheet_fee, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.run {
            adapter = adapterFee
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.loadingFee.observe(this@DialogFee, Observer {
            if (!it.isNullOrEmpty()) {
                adapterFee.updateData(it)
                progressBarSheet.visibility = View.GONE
            }
        })
    }

    override fun onResume() {
        viewModel.loadListScore()
        super.onResume()
    }
}