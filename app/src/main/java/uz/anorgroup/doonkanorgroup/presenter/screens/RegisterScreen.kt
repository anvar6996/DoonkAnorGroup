package uz.anorgroup.doonkanorgroup.presenter.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.widget.textChanges
import uz.anorgroup.doonkanorgroup.R
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.databinding.ScreenRegisterBinding
import uz.anorgroup.doonkanorgroup.presenter.viewmodel.RegisterViewModel
import uz.anorgroup.doonkanorgroup.presenter.viewmodel.impl.RegisterViewModelImpl
import uz.anorgroup.doonkanorgroup.utils.scope
import uz.anorgroup.doonkanorgroup.utils.showToast

@AndroidEntryPoint
class RegisterScreen : Fragment(R.layout.screen_register) {
    private val binding by viewBinding(ScreenRegisterBinding::bind)
    private val viewModel: RegisterViewModel by viewModels<RegisterViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.scope {
        combine(
            nameEditText.textChanges().map {
                it.length > 3
            },
            surnameEditText.textChanges().map {
                it.length > 3
            },
            transform = { name, surname -> name && surname }
        ).onEach {
            loginBtn.isEnabled = it
        }.launchIn(lifecycleScope)

//        loginBtn.setOnClickListener {
//            viewModel.register(
//                (
//                    "+998${editText.rawText}"
//                )
//            )
//        }
        viewModel.errorFlow.onEach {
            showToast(it)
        }.launchIn(lifecycleScope)

        viewModel.successFlow.onEach {
            showToast("Success")
        }.launchIn(lifecycleScope)

//        viewModel.progressFlow.onEach {
//            if (it) progress.show()
//            else progress.hide()
//        }.launchIn(lifecycleScope)
    }

}
