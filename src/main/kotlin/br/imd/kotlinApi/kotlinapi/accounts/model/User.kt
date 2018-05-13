package br.imd.kotlinApi.kotlinapi.accounts.model

import javax.persistence.*

/**
 *  Entity User
 */
@Entity
@Table(name = "User",schema = "accounts")
data class User constructor(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id          :Long?   = 0,
        val userName    :String? = null,
        val password    :String? = null

)