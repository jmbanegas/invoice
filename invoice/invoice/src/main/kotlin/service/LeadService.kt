package service

import entity.Lead
import org.springframework.stereotype.Service
import repository.LeadRepository

@Service
class LeadService(private val leadRepository: LeadRepository) {

    fun getLeadById(id: Long): Lead? = leadRepository.findById(id).orElse(null)

    fun createLead(lead: Lead): Lead = leadRepository.save(lead)
}
