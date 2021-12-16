package uz.anorgroup.doonkanorgroup.domain.usecase.usecaseimpl

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.ContinueSignUpRequest
import uz.anorgroup.doonkanorgroup.data.responce.ContinueResponse
import uz.anorgroup.doonkanorgroup.domain.repository.AuthRepository
import uz.anorgroup.doonkanorgroup.domain.usecase.RegisterScreenUseCase
import javax.inject.Inject

class RegisterScreenUseCaseImpl @Inject constructor(private val repository: AuthRepository) : RegisterScreenUseCase {
    override fun continueSingUp(request: ContinueSignUpRequest): Flow<Result<ContinueResponse>> = repository.confrim(request)
}