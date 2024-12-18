package entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "lead")
data class Lead(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val email: String?,
    val phone: String?,

    @ManyToOne
    @JoinColumn(name = "status_id")
    val status: Status? = null,

    val createdAt: LocalDate = LocalDate.now(),
    val updatedAt: LocalDate = LocalDate.now()
)
