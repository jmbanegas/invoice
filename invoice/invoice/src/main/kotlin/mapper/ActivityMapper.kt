package mapper

import entity.Activity

object ActivityMapper {
    fun toMap(activity: Activity): Map<String, Any?> {
        return mapOf(
            "id" to activity.id,
            "description" to activity.description,
            "scheduledAt" to activity.scheduledAt,
            "createdAt" to activity.createdAt,
            "updatedAt" to activity.updatedAt,
            "leadId" to activity.lead.id,
            "userId" to activity.user?.id
        )
    }
}
