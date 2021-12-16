package uz.anorgroup.doonkanorgroup.domain.repository.repositoryimpl

import kotlinx.coroutines.flow.Flow
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse
import uz.anorgroup.doonkanorgroup.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override fun login(request: LoginRequest): Flow<Result<LoginResponse>> {
        TODO("Not yet implemented")
    }

    override fun register(request: RegisterRequest): Flow<Result<RegisterResponse>> {
        TODO("Not yet implemented")
    }

    override fun verify(request: VerifyRequest): Flow<Result<VerifyResponse>> {
        TODO("Not yet implemented")
    }
}