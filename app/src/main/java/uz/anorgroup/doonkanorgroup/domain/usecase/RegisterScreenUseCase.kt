package uz.anorgroup.doonkanorgroup.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.ContinueSignUpRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.responce.ContinueResponse
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse

interface RegisterScreenUseCase {
    fun continueSingUp(request: ContinueSignUpRequest): Flow<Result<ContinueResponse>>

}