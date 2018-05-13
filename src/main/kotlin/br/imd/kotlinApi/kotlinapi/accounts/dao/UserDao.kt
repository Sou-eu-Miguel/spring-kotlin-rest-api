package br.imd.kotlinApi.kotlinapi.accounts.dao

import br.imd.kotlinApi.kotlinapi.accounts.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<User, Long> {
    fun findByUserName(userName: String): User
}