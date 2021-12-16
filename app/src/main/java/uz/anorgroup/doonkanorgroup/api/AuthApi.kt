package uz.anorgroup.doonkanorgroup.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest
import uz.anorgroup.doonkanorgroup.data.responce.LoginResponse
import uz.anorgroup.doonkanorgroup.data.responce.RegisterResponse

interface AuthApi {
    @POST("signIn")
    suspend fun login(@Body data: LoginRequest): Response<LoginResponse>

    @POST("signUp")
    suspend fun register(@Body data: RegisterRequest): Response<RegisterResponse>

    @POST("signUp")
    suspend fun continueSingUp(@Body data: RegisterRequest): Response<RegisterResponse>

//    @POST("verify")
//    suspend fun veryfyCode(@Body data: SmsVeryfyRequest): Response<VeriyfyResponce>
}