import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import response.ErrorResponse
import response.FailResponse
import response.SuccessResponse
import service.LeadService

@RestController
@RequestMapping("/leads")
class LeadController(private val leadService: LeadService) {

    @GetMapping
    fun getAllLeads(): ResponseEntity<Any> {
        val leads = leadService.getAllLeads()
        return ResponseEntity.ok(SuccessResponse(data = leads))
    }

    @GetMapping("/{id}")
    fun getLeadById(@PathVariable id: Long): ResponseEntity<Any> {
        val lead = leadService.getLeadById(id)
        return lead?.let { ResponseEntity.ok(SuccessResponse(data = it)) }
            ?: ResponseEntity.badRequest().body(FailResponse(data = mapOf("id" to "Lead not found")))
    }

    @PostMapping("/{leadId}/set-status")
    fun setLeadStatus(@PathVariable leadId: Long, @RequestParam status: String): ResponseEntity<Any> {
        return try {
            leadService.setLeadStatus(leadId, status)
            ResponseEntity.ok(SuccessResponse(data = "Status updated successfully"))
        } catch (ex: Exception) {
            ResponseEntity.internalServerError().body(ErrorResponse(message = "Failed to update status", details = ex.message))
        }
    }
}
git add .