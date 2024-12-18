package mapper

object StatusMapper {
    fun toMap(status: Status): Map<String, Any?> {
        return mapOf(
            "id" to status.id,
            "name" to status.name,
            "description" to status.description
        )
    }
}
