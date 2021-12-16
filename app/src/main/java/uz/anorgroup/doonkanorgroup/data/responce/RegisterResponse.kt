package uz.anorgroup.doonkanorgroup.data.responce

import com.google.gson.annotations.SerializedName


data class RegisterResponse(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: Data? = null,

    @field:SerializedName("message")
    val message: String? = null
)