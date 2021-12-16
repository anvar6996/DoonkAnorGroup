package uz.anorgroup.doonkanorgroup.domain.usecase.usecaseimpl

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse
import uz.anorgroup.doonkanorgroup.domain.repository.AuthRepository
import uz.anorgroup.doonkanorgroup.domain.usecase.LoginScreenUseCase
import javax.inject.Inject

class LoginScreenUseCaseImpl @Inject constructor(private val repositoryImpl: AuthRepository) : LoginScreenUseCase {
    override fun userLogin(authRequest: LoginRequest): Flow<Result<LoginResponse>> = repositoryImpl.login(authRequest)
}