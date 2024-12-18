package mapper

import entity.User

object UserMapper {
    fun toMap(user: User): Map<String, Any> {
        return mapOf(
            "id" to user.id,
            "name" to user.name,
            "email" to user.email,
            "role" to user.role,
            "createdAt" to user.createdAt
        )
    }
}
