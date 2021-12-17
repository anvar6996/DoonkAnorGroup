package uz.anorgroup.doonkanorgroup.domain.repository.repositoryimpl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.anorgroup.doonkanorgroup.data.api.AuthApi
import uz.anorgroup.doonkanorgroup.data.pref.MyPref
import uz.anorgroup.doonkanorgroup.data.request.ContinueSignUpRequest
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.data.responce.ContinueResponse
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse
import uz.anorgroup.doonkanorgroup.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val api: AuthApi, private val pref: MyPref) : AuthRepository {

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

    override fun confrim(request: ContinueSignUpRequest): Flow<Result<ContinueResponse>> = flow {
        val responce = api.continueSingUp(request)
        if (responce.isSuccessful) {
            emit(Result.success<ContinueResponse>(responce.body()!!))
        } else {
            emit(Result.failure(Throwable(responce.errorBody().toString())))
        }
    }.catch {
        val errorMessage = Throwable("Sever bilan muammo bo'ldi")
        emit(Result.failure(errorMessage))
    }.flowOn(Dispatchers.IO)

    override fun saveData(phoneNumber: String, name: String, lastName: String) {
        pref.name = name
        pref.phoneNumber = phoneNumber
        pref.surname
    }

    override fun register(request: RegisterRequest): Flow<Result<RegisterResponse>> = flow {
        val recponce = api.register(request)
        if (recponce.isSuccessful) {
            recponce.body()?.data?.let {
                pref.accessToken = it.token
            }
            emit(Result.success<RegisterResponse>(recponce.body()!!))
        } else {
            emit(Result.failure(Throwable(recponce.errorBody().toString())))
        }
    }.catch {
        val errorMessage = Throwable("Sever bilan muammo bo'ldi")
        emit(Result.failure(errorMessage))
    }.flowOn(Dispatchers.IO)

    override fun verify(request: VerifyRequest): Flow<Result<VerifyResponse>> = flow {
        val responce = api.verifyCode(request)
        if (responce.isSuccessful) {
            responce.body()?.data.let {
                if (it != null) {
                    pref.accessToken = it.token
                }
            }
            emit(Result.success<VerifyResponse>(responce.body()!!))
        } else {
            emit(Result.failure(Throwable(responce.errorBody().toString())))
        }
    }.catch {
        val errorMessage = Throwable("Sever bilan muammo bo'ldi")
        emit(Result.failure(errorMessage))
    }.flowOn(Dispatchers.IO)

}