package vn.edu.uit.managementforstudents.ui.fragments.intro.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*
import vn.edu.uit.managementforstudents.R
import vn.edu.uit.managementforstudents.databinding.FragmentLoginBinding
import vn.edu.uit.managementforstudents.module.models.MSSV
import vn.edu.uit.managementforstudents.module.models.MysharedPreferences
import vn.edu.uit.managementforstudents.ui.fragments.intro.IntroViewModel


class LoginFragment : Fragment(), LoginListener {
    private val viewModel: IntroViewModel by lazy {
        ViewModelProvider(requireActivity()).get(IntroViewModel::class.java)
    }
    private val sharedPreferences: MysharedPreferences by lazy {
        MysharedPreferences(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.listener = this@LoginFragment
        binding.lifecycleOwner = this@LoginFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listDangNhap.observe(
            this.viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (!it.isNullOrEmpty()) {
                    if (it[0].status == "success") {
                        if (sharedPreferences.getShare.getString(MSSV, null) == null) {
                            sharedPreferences.saveData(it[0].thongTinSinhVien[0])
                            Toast.makeText(requireActivity(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                        }
                        progressLogin.visibility = View.GONE
                        whorlLogin.stop()
                        findNavController().navigate(R.id.action_loginFragment_to_fragmentPlashScreen)
                    }
                }
            })
    }
    override fun onLoginPressed(view: View) {

        if (checkEmpty()) {
            progressLogin.visibility = View.VISIBLE
            whorlLogin.start()
            viewModel.loadDangNhap()
        } else
            Toast.makeText(requireActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show()

    }

    override fun onForgotPassword(view: View) {
        nav_host_fragment.findNavController()
            .navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        Toast.makeText(requireActivity(), "vào màn hình quên pass", Toast.LENGTH_LONG).show()
    }

    private fun checkEmpty(): Boolean {
        if (ed_account.text.isNullOrEmpty() || ed_account.text!!.trim() == "" || ed_pass.text.isNullOrEmpty() || ed_pass.text!!.trim().equals("")
        ) {
            return false
        }
        return true
    }

}