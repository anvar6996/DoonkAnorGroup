package uz.anorgroup.doonkanorgroup.data.request

import com.google.gson.annotations.SerializedName

data class ContinueSignUpRequest(

	@field:SerializedName("phone")
	val phone: String? = null
)
