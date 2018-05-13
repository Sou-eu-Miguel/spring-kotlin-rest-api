package br.imd.kotlinApi.kotlinapi.core.resource

import br.imd.kotlinApi.kotlinapi.accounts.dao.UserDao
import br.imd.kotlinApi.kotlinapi.core.config.SecurityConfig
import org.springframework.http.ResponseEntity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/auth")
class Access(private val userDao: UserDao) {

    @GetMapping("/login")
    fun login(@Valid user: User): ResponseEntity<UserDetails> {
        val user = userDao.findByUserName(user.username)

        val userDetails = org.springframework.security.core.userdetails.User(user.userName, user.password,
                listOf(SimpleGrantedAuthority(SecurityConfig.ROLES.ROLE_USER)))

        if (userDetails.isEnabled) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(userDetails)
    }
}