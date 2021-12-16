package uz.anorgroup.doonkanorgroup.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse

interface LoginScreenUseCase {

    fun userLogin(authRequest: LoginRequest): Flow<Result<LoginResponse>>

}