package br.imd.kotlinApi.kotlinapi.anime.dao

import br.imd.kotlinApi.kotlinapi.anime.model.Chapter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChapterDao : JpaRepository<Chapter,Long>