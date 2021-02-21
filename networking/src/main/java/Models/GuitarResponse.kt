package Models

data class GuitarResponse(
    val guitars: List<Guitar>,
    val message: String,
    val status: Int
)