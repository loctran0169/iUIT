package vn.edu.uit.managementforstudents.ui.fragments.account_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_account_edit.*
import vn.edu.uit.managementforstudents.databinding.FragmentAccountEditBinding

class EditAccountFragment : Fragment(), EditAccountListener {

    var isEdit = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAccountEditBinding.inflate(inflater, container, false)
        binding.listener = this@EditAccountFragment
        binding.lifecycleOwner = this@EditAccountFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onBackPressed(view: View) {
        activity!!.onBackPressed()
    }

    override fun onAcceptPressed(view: View) {
        Toast.makeText(context, "Chỉnh sửa ok r", Toast.LENGTH_SHORT).show()
        isEdit = false
        btn_accept_edit_account.visibility = View.GONE
        btn_edit.visibility = View.VISIBLE
    }

    override fun onEditPressed(view: View) {
        if (!isEdit) {
            btn_accept_edit_account.visibility = View.VISIBLE
            btn_edit.visibility = View.GONE
        }
    }
}