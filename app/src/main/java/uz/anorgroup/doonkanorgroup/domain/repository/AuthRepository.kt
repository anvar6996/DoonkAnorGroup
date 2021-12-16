package uz.anorgroup.doonkanorgroup.domain.repository

import uz.anorgroup.doonkanorgroup.data.request.LoginRequest
import uz.anorgroup.doonkanorgroup.data.request.RegisterRequest

interface AuthRepository {
    fun login(request: LoginRequest)
    fun register(request: RegisterRequest)
    fun verify(request: RegisterRequest)
}