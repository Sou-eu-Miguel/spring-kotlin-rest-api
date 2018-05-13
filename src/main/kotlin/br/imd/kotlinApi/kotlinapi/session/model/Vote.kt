package br.imd.kotlinApi.kotlinapi.session.model

import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

/**
 *  Entity vote
 */
@Entity
@Table(name = "vote",schema = "session")
data class Vote constructor(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id          :Long?   = 0,

        @Max(10)
        @Min(0)
        val note        :Int?    = 0,
        val observation :String? = null
)