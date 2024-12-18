package dto

import java.time.LocalDate

data class ActivityDTO(
    val description: String,
    val scheduledAt: LocalDate,
    val leadId: Int,
    val userId: Int?
)
