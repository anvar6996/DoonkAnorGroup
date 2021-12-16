package uz.anorgroup.doonkanorgroup.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse

interface RegisterScreenUseCase {
    fun resgiter(request: RegisterRequest): Flow<Result<RegisterResponse>>

}