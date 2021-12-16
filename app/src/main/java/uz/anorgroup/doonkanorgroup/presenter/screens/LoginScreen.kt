package uz.anorgroup.doonkanorgroup.presenter.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.databinding.ScreenLoginBinding
import uz.anorgroup.doonkanorgroup.presenter.viewmodel.LoginViewModel
import uz.anorgroup.doonkanorgroup.presenter.viewmodel.impl.LoginViewModelImpl
import uz.anorgroup.doonkanorgroup.utils.scope
import uz.anorgroup.doonkanorgroup.utils.showToast

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {
    private val binding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {

        viewModel.errorFlow.onEach {
            showToast(it)
        }.launchIn(lifecycleScope)

        viewModel.successFlow.onEach {
            showToast("Success")
        }.launchIn(lifecycleScope)

        viewModel.openRegisterFlow.onEach {
            findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
        }.launchIn(lifecycleScope)

        viewModel.progressFlow.onEach {
            if (it) progress.show()
            else progress.hide()
        }.launchIn(lifecycleScope)
    }
}