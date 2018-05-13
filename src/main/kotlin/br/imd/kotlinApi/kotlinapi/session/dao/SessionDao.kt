package br.imd.kotlinApi.kotlinapi.session.dao

import br.imd.kotlinApi.kotlinapi.session.model.Session
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionDao: JpaRepository<Session, Long>