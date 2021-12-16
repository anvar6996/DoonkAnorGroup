package uz.anorgroup.doonkanorgroup.presenter.viewmodel.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.domain.usecase.LoginScreenUseCase
import uz.anorgroup.doonkanorgroup.presenter.viewmodel.LoginViewModel
import uz.anorgroup.doonkanorgroup.utils.eventValueFlow
import uz.anorgroup.doonkanorgroup.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(private val useCase: LoginScreenUseCase) : ViewModel(), LoginViewModel {
    override val errorFlow = eventValueFlow<String>()
    override val progressFlow = eventValueFlow<Boolean>()
    override val successFlow = eventValueFlow<Unit>()

    override fun login(request: LoginRequest) {
        if(!isConnected()){

        }
    }
}