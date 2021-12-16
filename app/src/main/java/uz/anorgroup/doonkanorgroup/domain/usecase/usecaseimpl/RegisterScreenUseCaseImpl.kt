package uz.anorgroup.doonkanorgroup.domain.usecase.usecaseimpl

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.domain.repository.AuthRepository
import uz.anorgroup.doonkanorgroup.domain.usecase.RegisterScreenUseCase
import javax.inject.Inject

class RegisterScreenUseCaseImpl @Inject constructor(private  val repository: AuthRepository) : RegisterScreenUseCase {
    override fun resgiter(request: RegisterRequest): Flow<Result<RegisterResponse>> = repository.register(request)

}