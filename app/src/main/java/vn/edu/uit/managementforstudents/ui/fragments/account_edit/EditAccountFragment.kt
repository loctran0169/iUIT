package vn.edu.uit.managementforstudents.ui.fragments.account_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_account_edit.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentAccountEditBinding
import vn.edu.uit.managementforstudents.module.models.AVATAR
import vn.edu.uit.managementforstudents.module.models.MysharedPreferences
import vn.edu.uit.managementforstudents.module.models.ThongTinSinhVien


class EditAccountFragment : Fragment(), EditAccountListener {

    var isEdit = false
    val viewModel: ViewModelAccountEdit by lazy {
        ViewModelProvider(requireActivity()).get(ViewModelAccountEdit::class.java)
    }
    private val sharedPreferences: MysharedPreferences by lazy {
        MysharedPreferences(requireActivity())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAccountEditBinding.inflate(inflater, container, false)
        binding.listener = this@EditAccountFragment
        binding.lifecycleOwner = this@EditAccountFragment
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        disableAllEditText()
        bindingThongTin(sharedPreferences.loadData())

//        viewModel.loadingThongTin.observe(this.viewLifecycleOwner, Observer {
//            if (it != null) {
//                bindingThongTin(it)
//            }
//        })
    }

    override fun onBackPressed(view: View) {
        requireActivity().onBackPressed()
    }

    override fun onAcceptPressed(view: View) {
        Toast.makeText(context, "Chỉnh sửa ok r", Toast.LENGTH_SHORT).show()
        getData()?.let { sharedPreferences.saveData(it) }
        isEdit = false
        btn_accept_edit_account.visibility = View.INVISIBLE
        btn_edit.visibility = View.VISIBLE
        disableAllEditText()
    }

    override fun onEditPressed(view: View) {
        if (!isEdit) {
            btn_accept_edit_account.visibility = View.VISIBLE
            btn_edit.visibility = View.INVISIBLE
            enableAllEditText()
        }
    }

    private fun disableAllEditText() {
        tvSdt.isFocusable = false
        tvDiaChi.isFocusable = false
        tvFacebook.isFocusable = false
    }

    private fun enableAllEditText() {
        tvSdt.isFocusable = true
        tvSdt.isFocusableInTouchMode = true
        tvDiaChi.isFocusable = true
        tvDiaChi.isFocusableInTouchMode = true
        tvFacebook.isFocusable = true
        tvFacebook.isFocusableInTouchMode = true
    }

    private fun bindingThongTin(data: ThongTinSinhVien?) {
        if (data != null) {
            Glide.with(this)
                .load(data.avatar)
                .error(resources.getDrawable(R.drawable.ic_avatar, context?.theme))
                .into(img_avatar_edit)
            tvName.text = data.hoTen
            tvMSSV.setText(data.maSinhVien)
            tvNgaySinh.setText(data.ngaySinh)
            tvGioiTinh.setText(data.gioiTinh)
            tvEmail.setText(data.email)
            tvNganh.setText(data.nganh)
            tvLop.setText(data.lop)
            tvSdt.setText(data.sdt)
            tvDiaChi.setText(data.diaChi)
            tvFacebook.setText(data.facebook)
        }
    }

    private fun getData(): ThongTinSinhVien? {
        val data = ThongTinSinhVien(null, null, null, null, null, null, null, null, null, null, "")

        data.hoTen = tvName.text.toString()
        data.maSinhVien = tvMSSV.text.toString()
        data.ngaySinh = tvNgaySinh.text.toString()
        data.gioiTinh = tvGioiTinh.text.toString()
        data.email = tvEmail.text.toString()
        data.nganh = tvNganh.text.toString()
        data.lop = tvLop.text.toString()
        data.sdt = tvSdt.text.toString()
        data.diaChi = tvDiaChi.text.toString()
        data.facebook = tvFacebook.text.toString()
        data.avatar = sharedPreferences.getStringValue(AVATAR)

        return data
    }
}