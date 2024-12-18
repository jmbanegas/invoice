package service

import entity.Activity
import org.springframework.stereotype.Service
import repository.ActivityRepository

@Service
class ActivityService(private val activityRepository: ActivityRepository) {

    fun getActivityById(id: Long): Activity? = activityRepository.findById(id).orElse(null)

    fun createActivity(activity: Activity): Activity = activityRepository.save(activity)

    fun getAllActivities(): List<Activity> = activityRepository.findAll()
}
