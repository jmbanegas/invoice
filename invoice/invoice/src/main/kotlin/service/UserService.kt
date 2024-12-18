package service

import entity.User
import org.springframework.stereotype.Service
import repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun createUser(user: User): User = userRepository.save(user)
}
