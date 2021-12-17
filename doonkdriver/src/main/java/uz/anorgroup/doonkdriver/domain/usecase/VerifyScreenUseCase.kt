package uz.anorgroup.doonkanorgroup.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkdriver.data.request.RegisterRequest
import uz.anorgroup.doonkdriver.data.request.VerifyRequest
import uz.anorgroup.doonkdriver.data.responce.RegisterResponse
import uz.anorgroup.doonkdriver.data.responce.VerifyResponse


interface VerifyScreenUseCase {
    fun sendSmsVerify(request: VerifyRequest): Flow<Result<VerifyResponse>>
    fun register(request: RegisterRequest): Flow<Result<RegisterResponse>>
    fun saveData(phoneNumber: String, name: String, lastName: String)
}