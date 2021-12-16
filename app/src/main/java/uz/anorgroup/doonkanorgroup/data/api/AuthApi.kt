package uz.anorgroup.doonkanorgroup.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.anorgroup.doonkanorgroup.data.request.ContinueSignUpRequest
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.request.VerifyRequest
import uz.anorgroup.doonkanorgroup.data.responce.ContinueResponse
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse
import uz.anorgroup.doonkanorgroup.data.responce.VerifyResponse

interface AuthApi {

    @POST("signIn")
    suspend fun login(@Body data: LoginRequest): Response<LoginResponse>

    @POST("signUp")
    suspend fun register(@Body data: RegisterRequest): Response<RegisterResponse>

    @POST("confirm")
    suspend fun continueSingUp(@Body data: ContinueSignUpRequest): Response<ContinueResponse>

    @POST("verify")
    suspend fun veryfyCode(@Body data: VerifyRequest): Response<VerifyResponse>
}