package entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "activity")
data class Activity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val description: String,
    val scheduledAt: LocalDate?,

    val createdAt: LocalDate = LocalDate.now(),
    val updatedAt: LocalDate = LocalDate.now(),

    @ManyToOne
    @JoinColumn(name = "lead_id")
    val lead: Lead,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User?
)
