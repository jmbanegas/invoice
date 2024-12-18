package dto

data class LeadDTO(
    val name: String,
    val email: String?,
    val phone: String?,
    val statusId: Int
)
