package vn.edu.uit.managementforstudents.ui.dialogs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_history.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.module.models.LichSu

class BaseBottomSheetHistory(val data: LichSu) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_history, null)
        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        btn_play.setOnClickListener {
            val webView = WebView(requireContext())
            webView.settings.javaScriptEnabled = true
            webView.webChromeClient = WebChromeClient()
            webView.loadUrl(data.recordVideo)
        }
    }

    fun initData() {
        tvNameSub.text = data.monHoc?.tenMonHoc ?: ""
        tvTeacherName.text = data.monHoc?.tenGiaoVien ?: ""
        tvDateFinish.text = (data.thoiGianBatDau)?.substringBefore(" ") ?: ""
        tvNoiDung.text = data.noiDung
        tvYeuCau.text = data.yeuCau
        if (data.recordVideo.isNullOrEmpty())
            btn_play.visibility = View.GONE
    }
}