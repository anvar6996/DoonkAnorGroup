package uz.anorgroup.doonkanorgroup.data.responce

import com.google.gson.annotations.SerializedName

data class VerifyResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Data(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("gender")
	val gender: Int? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
