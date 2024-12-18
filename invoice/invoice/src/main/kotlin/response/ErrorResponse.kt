package response

data class ErrorResponse(
    val status: String = "error",
    val message: String,
    val details: Any? = null
)
