package uz.anorgroup.doonkanorgroup.data

data class ChatData constructor(
    val date: String,
    val time: String,
    val name: String,
    val placeName: String,
    val senderPlace: String,
    val chatText: String
)