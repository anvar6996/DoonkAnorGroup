package uz.anorgroup.doonkanorgroup.data.request

data class RegisterRequest(
    val code: String? = null,
    val phone: String? = null,
    val lastName: String? = null,
    val firstName: String? = null
)

