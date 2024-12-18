package controller

import entity.User
import mapper.UserMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import service.UserService

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<Any> {
        val user = userService.getUserById(id)
        return if (user != null) {
            ResponseEntity.ok(UserMapper.toMap(user))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<Any> {
        val newUser = userService.createUser(user)
        return ResponseEntity.ok(UserMapper.toMap(newUser))
    }
}
