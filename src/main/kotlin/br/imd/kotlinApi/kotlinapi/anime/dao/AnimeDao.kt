package br.imd.kotlinApi.kotlinapi.anime.dao

import br.imd.kotlinApi.kotlinapi.anime.model.Anime
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnimeDao: JpaRepository<Anime,Long>