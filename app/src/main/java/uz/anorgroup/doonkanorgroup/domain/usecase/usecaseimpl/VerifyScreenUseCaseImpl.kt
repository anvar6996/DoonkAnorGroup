package uz.anorgroup.doonkanorgroup.domain.usecase.usecaseimpl

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse
import uz.anorgroup.doonkanorgroup.domain.repository.AuthRepository
import uz.anorgroup.doonkanorgroup.domain.usecase.VerifyScreenUseCase
import javax.inject.Inject

class VerifyScreenUseCaseImpl @Inject constructor(private val repository: AuthRepository) : VerifyScreenUseCase {

    override fun register(request: RegisterRequest): Flow<Result<RegisterResponse>> = repository.register(request)
    override fun sendSmsVerify(request: VerifyRequest): Flow<Result<VerifyResponse>> = repository.verify(request)
}