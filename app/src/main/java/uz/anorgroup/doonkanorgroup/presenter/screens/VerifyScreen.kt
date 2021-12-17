package uz.anorgroup.doonkanorgroup.presenter.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fraggjkee.smsconfirmationview.SmsConfirmationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.databinding.ScreenVerifyBinding
import uz.anorgroup.doonkanorgroup.presenter.viewmodel.VerifyViewModel
import uz.anorgroup.doonkanorgroup.presenter.viewmodel.impl.VerifyViewModelImpl
import uz.anorgroup.doonkanorgroup.utils.scope
import uz.anorgroup.doonkanorgroup.utils.showToast

@AndroidEntryPoint
class VerifyScreen : Fragment(R.layout.screen_verify) {
    private val binding by viewBinding(ScreenVerifyBinding::bind)
    private val viewModel: VerifyViewModel by viewModels<VerifyViewModelImpl>()
    private var s: String? = null
    private val args: VerifyScreenArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        loginBtn.isEnabled=false
        val bundle=requireArguments()
        val phone=bundle.getString("phone") as String
        smsVerifyCode.onChangeListener = SmsConfirmationView.OnChangeListener { code, isComplete ->
            loginBtn.isEnabled=isComplete
            if (isComplete) {
                s = code
            }
        }
        loginBtn.setOnClickListener {
            var code = ""
            s?.let {
                code = it
            }
            viewModel.verify(
                VerifyRequest(
                    code, phone
                )
            )
        }

        viewModel.errorFlow.onEach {
            showToast("Error code")
        }.launchIn(lifecycleScope)

        viewModel.progressFlow.onEach {
            if (it) progress.show()
            else progress.hide()
        }.launchIn(lifecycleScope)

        viewModel.successFlow.onEach {
            showToast("Success")
        }.launchIn(lifecycleScope)

        viewModel.openMainFlow.onEach {
            findNavController().navigate(R.id.mainScreen)
        }.launchIn(lifecycleScope)
    }

}