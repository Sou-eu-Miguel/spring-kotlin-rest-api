package br.imd.kotlinApi.kotlinapi.anime.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.CascadeType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.OneToMany


/**
 *  Entity Anime
 */
@Entity
@Table(name = "anime",schema = "public")
data class Anime constructor(

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id              :Long?   = 0,
    val name            :String? = null,
    val description     :String? = null,

    @OneToMany(cascade = [CascadeType.REFRESH,CascadeType.REMOVE])
    val chapters        :List<Chapter>? = null
)