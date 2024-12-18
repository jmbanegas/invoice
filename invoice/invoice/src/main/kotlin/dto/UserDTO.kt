package dto

data class UserDTO(
    val name: String,
    val email: String,
    val role: String? = "Agent"
)
