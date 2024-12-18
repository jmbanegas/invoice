package mapper

import entity.Lead

object LeadMapper {
    fun toMap(lead: Lead): Map<String, Any> {
        return mapOf(
            "id" to lead.id,
            "name" to lead.name,
            "email" to lead.email,
            "phone" to lead.phone,
            "status" to lead.status?.name,
            "createdAt" to lead.createdAt
        )
    }
}

}
