package uz.anorgroup.doonkanorgroup.data.responce

import com.google.gson.annotations.SerializedName


data class RegisterResponse(
    val code: Int,
    val data: Data,
    val message: String
)