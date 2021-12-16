package uz.anorgroup.doonkanorgroup.data.request

import com.google.gson.annotations.SerializedName

data class VerifyRequest(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null
)
