package uz.anorgroup.doonkanorgroup.data.request

data class RegisterRequest(
    val code: String,
    val phone: String,
    val lastName: String,
    val firstName: String
)

