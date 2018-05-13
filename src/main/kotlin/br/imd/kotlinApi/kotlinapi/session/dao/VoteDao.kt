package br.imd.kotlinApi.kotlinapi.session.dao

import br.imd.kotlinApi.kotlinapi.session.model.Vote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VoteDao: JpaRepository<Vote, Long>