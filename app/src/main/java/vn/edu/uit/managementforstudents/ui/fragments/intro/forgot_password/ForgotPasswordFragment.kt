package vn.edu.uit.managementforstudents.ui.fragments.intro.forgot_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }


    override fun onAcceptPressed(view: View) =
        if (isEmailValid(tv_email_forgot.editText?.text?.trim().toString())) {
            progressForgot.visibility = View.VISIBLE
            whorlForgot.start()
            viewModel.listDangNhap.observe(
                this.viewLifecycleOwner,
                androidx.lifecycle.Observer {
                    if (!it.isNullOrEmpty()) {
                        if (it[0].status == "success") {
                            progressForgot.visibility = View.GONE
                            whorlForgot.stop()
                            Toast.makeText(
                                requireActivity(),
                                "Đã gửi email đến bạn",
                                Toast.LENGTH_LONG
                            ).show()
                            activity?.onBackPressed()
                        }
                    }
                })
        } else
            Toast.makeText(requireActivity(), "Vui lòng đúng email", Toast.LENGTH_LONG).show()

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
}