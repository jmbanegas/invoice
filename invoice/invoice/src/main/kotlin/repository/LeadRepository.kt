package repository

import entity.Lead
import org.springframework.data.jpa.repository.JpaRepository

interface LeadRepository : JpaRepository<Lead, Long>
