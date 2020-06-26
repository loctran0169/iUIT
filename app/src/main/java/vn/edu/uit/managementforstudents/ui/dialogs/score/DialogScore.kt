package vn.edu.uit.managementforstudents.ui.dialogs.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_fee.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.adapters.AdapterScoreOneTerm

class DialogScore : BottomSheetDialogFragment() {
    val viewModel: ViewModelScore by lazy {
        ViewModelProviders
            .of(requireActivity())
            .get(ViewModelScore::class.java)
    }
    private val adapterScoreOneTerm: AdapterScoreOneTerm by lazy {
        AdapterScoreOneTerm(requireContext(), mutableListOf())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_fee, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolBarFee.title="Bảng điểm"
        recyclerView.run {
            adapter = adapterScoreOneTerm
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.loadingScore.observe(this@DialogScore, Observer {
            if(!it.isNullOrEmpty()){
                adapterScoreOneTerm.updateData(it)
                progressBarSheet.visibility=View.GONE
            }
        })
    }
}