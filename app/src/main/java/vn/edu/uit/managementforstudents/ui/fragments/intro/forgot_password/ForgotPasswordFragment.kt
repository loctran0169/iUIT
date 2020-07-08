package vn.edu.uit.managementforstudents.ui.fragments.intro.forgot_password

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
import kotlinx.android.synthetic.main.fragment_forgot_password.*
import vn.edu.uit.managementforstudents.databinding.FragmentForgotPasswordBinding
import vn.edu.uit.managementforstudents.ui.fragments.intro.IntroViewModel
import java.util.regex.Pattern

class ForgotPasswordFragment : Fragment(), ForgotListener {
    private val viewModel: IntroViewModel by lazy {
        ViewModelProvider(requireActivity()).get(IntroViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        binding.listener = this@ForgotPasswordFragment
        binding.lifecycleOwner = this@ForgotPasswordFragment
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listQuenMatKhau.observe(
            this.viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (!it.isNullOrEmpty()) {
                    if (it[0].status == "success") {
                        progressForgot.visibility = View.GONE
                        whorlForgot.stop()
                        Toast.makeText(requireActivity(), "Đã gửi đến email của bạn", Toast.LENGTH_LONG).show()
                        viewModel.listQuenMatKhau.value = mutableListOf()
                        activity?.onBackPressed()
                    }
                }
            })

        tv_email_forgot?.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setEmail(s.toString())
            }

        })
    }

    override fun onAcceptPressed(view: View) =
        if (isEmailValid(tv_email_forgot.editText?.text?.trim().toString())) {
            progressForgot.visibility = View.VISIBLE
            whorlForgot.start()
            viewModel.loadQuenMatKhau()
        } else
            Toast.makeText(requireActivity(), "Vui lòng đúng email", Toast.LENGTH_LONG).show()

    override fun onHideKeyBoardPress(view: View) {
        hideKeyBoard()
    }

    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    fun hideKeyBoard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }
}