package br.imd.kotlinApi.kotlinapi.anime.model

import java.time.Duration
import javax.persistence.*

/**
 *  Entity Chapter
 */
@Entity
@Table(name = "chapter",schema = "public")
data class Chapter(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id              :Long,
    val name            :String,
    val description     :String,
    val duration        :Duration
)