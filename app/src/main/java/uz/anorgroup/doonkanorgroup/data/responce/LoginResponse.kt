package uz.anorgroup.doonkanorgroup.data.responce

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: Any? = null,

	@field:SerializedName("message")
	val message: String? = null
)
