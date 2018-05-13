package br.imd.kotlinApi.kotlinapi.session.model

import br.imd.kotlinApi.kotlinapi.anime.model.Anime
import br.imd.kotlinApi.kotlinapi.accounts.model.User
import javax.persistence.*

/**
 *  Entity Session
 */
@Entity
@Table(name = "session",schema = "session")
class Session(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id      :Long,

        @OneToMany(cascade = [CascadeType.REFRESH])
        val animes  :List<Anime>?,

        @OneToMany(cascade = [CascadeType.REFRESH])
        val users   :List<User>
)