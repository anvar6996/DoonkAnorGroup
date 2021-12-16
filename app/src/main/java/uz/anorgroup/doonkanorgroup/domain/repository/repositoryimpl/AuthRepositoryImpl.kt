package uz.anorgroup.doonkanorgroup.domain.repository.repositoryimpl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.anorgroup.doonkanorgroup.data.api.AuthApi
import uz.anorgroup.doonkanorgroup.data.pref.MyPref
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse
import uz.anorgroup.doonkanorgroup.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val api: AuthApi, private val pre: MyPref) : AuthRepository {

    override fun login(request: LoginRequest): Flow<Result<LoginResponse>> = flow {
        val responce = api.login(request)
        if (responce.isSuccessful) {
            emit(Result.success<LoginResponse>(responce.body()!!))
        } else {
            emit(Result.failure(Throwable(responce.errorBody().toString())))
        }
    }.catch {
        val errorMessage = Throwable("Sever bilan muammo bo'ldi")
        emit(Result.failure(errorMessage))
    }.flowOn(Dispatchers.IO)

    override fun register(request: RegisterRequest): Flow<Result<RegisterResponse>> = flow {
        val responce = api.register(request)
        if (responce.isSuccessful) {
            emit(Result.success<RegisterResponse>(responce.body()!!))
        } else {
            emit(Result.failure(Throwable(responce.errorBody().toString())))
        }
    }.catch {
        val errorMessage = Throwable("Sever bilan muammo bo'ldi")
        emit(Result.failure(errorMessage))
    }.flowOn(Dispatchers.IO)

    override fun verify(request: VerifyRequest): Flow<Result<VerifyResponse>> = flow {
        val responce = api.veryfyCode(request)
        if (responce.isSuccessful) {
            emit(Result.success<VerifyResponse>(responce.body()!!))
        } else {
            emit(Result.failure(Throwable(responce.errorBody().toString())))
        }
    }.catch {
        val errorMessage = Throwable("Sever bilan muammo bo'ldi")
        emit(Result.failure(errorMessage))
    }.flowOn(Dispatchers.IO)

}