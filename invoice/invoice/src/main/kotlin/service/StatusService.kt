package service

import entity.Status
import org.springframework.stereotype.Service
import repository.StatusRepository

@Service
class StatusService(private val statusRepository: StatusRepository) {

    fun getStatusById(id: Long): Status? = statusRepository.findById(id).orElse(null)

    fun createStatus(status: Status): Status = statusRepository.save(status)

    fun getAllStatuses(): List<Status> = statusRepository.findAll()
}
