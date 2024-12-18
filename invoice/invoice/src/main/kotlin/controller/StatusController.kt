package controller

import entity.Status
import mapper.StatusMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import service.StatusService

@RestController
@RequestMapping("/statuses")
class StatusController(private val statusService: StatusService) {

    @GetMapping("/{id}")
    fun getStatusById(@PathVariable id: Long): ResponseEntity<Any> {
        val status = statusService.getStatusById(id)
        return if (status != null) {
            ResponseEntity.ok(StatusMapper.toMap(status))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createStatus(@RequestBody status: Status): ResponseEntity<Any> {
        val newStatus = statusService.createStatus(status)
        return ResponseEntity.ok(StatusMapper.toMap(newStatus))
    }

    @GetMapping
    fun getAllStatuses(): ResponseEntity<List<Map<String, Any?>>> {
        val statuses = statusService.getAllStatuses().map { StatusMapper.toMap(it) }
        return ResponseEntity.ok(statuses)
    }
}
