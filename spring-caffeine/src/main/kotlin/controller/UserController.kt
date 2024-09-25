package com.github.rrickson.kotlinpocs.controller
import com.github.rrickson.kotlinpocs.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController {
    @Autowired
    private val userService: UserService = UserService()

    @GetMapping("/user/{id}")
    fun getUser(@PathVariable("id") userId: Long): ResponseEntity<String> {
        return ResponseEntity.ok(userService.getUser(userId))
    }
}