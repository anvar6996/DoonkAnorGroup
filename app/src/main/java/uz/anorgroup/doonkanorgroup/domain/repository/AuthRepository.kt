package uz.anorgroup.doonkanorgroup.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse

interface AuthRepository {
    fun login(request: LoginRequest): Flow<Result<LoginResponse>>
    fun register(request: RegisterRequest): Flow<Result<RegisterResponse>>
    fun verify(request: VerifyRequest): Flow<Result<VerifyResponse>>
//    fun confrim(request: ContinueSignUpRequest): Flow<Result<Respo>>
}