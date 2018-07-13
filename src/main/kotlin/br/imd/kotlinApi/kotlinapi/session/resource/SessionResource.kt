package br.imd.kotlinApi.kotlinapi.session.resource

import br.imd.kotlinApi.kotlinapi.session.dao.SessionDao
import br.imd.kotlinApi.kotlinapi.session.model.Session
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 *  Rest Controller API for Entity Session
 */
@RestController
@RequestMapping("/sessions", produces = ["application/json"])
class SessionResource(private val sessionDao : SessionDao){

    /**
     * Return list with all registered Session
     */
    @GetMapping
    fun listAll():List<Session> = sessionDao.findAll()

    /**
     *  Save new Session in database
     */
    @PostMapping
    fun save(@Valid @RequestBody session: Session): Session = sessionDao.save(session)

    /**
     * Return Session data according id
     */
    @GetMapping("/{id}")
    fun getSessionById(@PathVariable("id") sessionId:Long): ResponseEntity<Session> =
            sessionDao.findById(sessionId).map { session -> ResponseEntity.ok(session)}
                    .orElse(ResponseEntity.notFound().build())

    /**
     * Update Session data according id
     */
    @PutMapping("/{id}")
    fun updateSessionById(@PathVariable("id") sessionId: Long, @Valid @RequestBody sessionNew: Session): ResponseEntity<Session> {
        return sessionDao.findById(sessionId).map { sessionExisting ->

            val sessionUpdated: Session = sessionExisting.copy(
                    animes     =  sessionNew.animes,
                    users      =  sessionNew.users
            )

            ResponseEntity.ok().body(sessionDao.save(sessionUpdated))
        }.orElse(ResponseEntity.notFound().build())
    }

    /**
     * Deleting Session data according id
     */
    @DeleteMapping("/{id}")
    fun deleteSessionById(@PathVariable("id") sessionId: Long): ResponseEntity<Void> {
        return sessionDao.findById(sessionId).map { sessionExisting ->
            sessionDao.delete(sessionExisting)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}