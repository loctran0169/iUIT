package vn.edu.uit.managementforstudents.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_fee.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.data.adapters.AdapterFee

class DialogFee : BottomSheetDialogFragment() {
    private val adapterFee: AdapterFee by lazy {
        AdapterFee()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = LayoutInflater.from(context).inflate(R.layout.fragment_fee, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.run {
            adapter = adapterFee
            layoutManager = LinearLayoutManager(context)
        }
    }
}