package uz.anorgroup.doonkanorgroup.data.request

import com.google.gson.annotations.SerializedName

data class VerifyRequest(
	val code: String? = null,
	val phone: String? = null
)
