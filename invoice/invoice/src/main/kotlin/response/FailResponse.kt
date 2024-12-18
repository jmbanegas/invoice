package response

data class FailResponse(
    val status: String = "fail",
    val data: Map<String, Any>
)
