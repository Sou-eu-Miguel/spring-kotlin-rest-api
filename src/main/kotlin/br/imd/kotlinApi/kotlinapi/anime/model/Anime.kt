package br.imd.kotlinApi.kotlinapi.anime.model

import javax.persistence.*

/**
 *  Entity Anime
 */
@Entity
@Table(name = "anime",schema = "public")
data class Anime(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id              :Long,
    val name            :String,
    val description     :String,

    @OneToMany(cascade = [CascadeType.ALL])
    val chapters        :List<Chapter>?
)