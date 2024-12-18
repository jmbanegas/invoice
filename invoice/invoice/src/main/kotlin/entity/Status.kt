package entity

import jakarta.persistence.*

@Entity
@Table(name = "status")
data class Status(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val name: String,

    val description: String? = null
)
