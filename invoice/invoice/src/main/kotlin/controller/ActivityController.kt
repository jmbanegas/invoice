import entity.Activity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import response.ErrorResponse
import response.FailResponse
import response.SuccessResponse
import service.ActivityService

@RestController
@RequestMapping("/activities")
class ActivityController(private val activityService: ActivityService) {

    @GetMapping
    fun getAllActivities(): ResponseEntity<Any> {
        val activities = activityService.getAllActivities()
        return ResponseEntity.ok(SuccessResponse(data = activities))
    }

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Long): ResponseEntity<Any> {
        val activity = activityService.getActivityById(id)
        return activity?.let { ResponseEntity.ok(SuccessResponse(data = it)) }
            ?: ResponseEntity.badRequest().body(FailResponse(data = mapOf("id" to "Activity not found")))
    }
}

@RestController
@RequestMapping("/leads/{leadId}/activities")
class LeadActivityController(private val activityService: ActivityService) {

    @PostMapping
    fun createActivityForLead(@PathVariable leadId: Long, @RequestBody activity: Activity): ResponseEntity<Any> {
        return try {
            val newActivity = activityService.createActivityForLead(leadId, activity)
            ResponseEntity.ok(SuccessResponse(data = newActivity))
        } catch (ex: Exception) {
            ResponseEntity.internalServerError().body(ErrorResponse(message = "Failed to create activity", details = ex.message))
        }
    }
}
