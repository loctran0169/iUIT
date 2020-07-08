package vn.edu.uit.managementforstudents.ui.fragments.intro.login

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
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
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listDangNhap.observe(
            this.viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (!it.isNullOrEmpty()) {
                    if (it[0].status == "success" && !viewModel.isLogin) {
                        if (sharedPreferences.getShare.getString(MSSV, null) == null) {
                            sharedPreferences.saveData(it[0].thongTinSinhVien[0])
                            Toast.makeText(requireActivity(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                        }
                        progressLogin.visibility = View.GONE
                        whorlLogin.stop()
                        viewModel.listDangNhap.value = mutableListOf()
                        findNavController().navigate(R.id.action_loginFragment_to_fragmentPlashScreen)
                    }
                    viewModel.isLogin = false
                }
            })
        tv_Email?.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
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
    }

    override fun onHideKeyBoardPress(view: View) {
        hideKeyBoard()
    }

    private fun checkEmpty(): Boolean {
        if (ed_account.text.isNullOrEmpty() || ed_account.text!!.trim() == "" || ed_pass.text.isNullOrEmpty() || ed_pass.text!!.trim().equals("")
        ) {
            return false
        }
        return true
    }

    fun hideKeyBoard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }
}