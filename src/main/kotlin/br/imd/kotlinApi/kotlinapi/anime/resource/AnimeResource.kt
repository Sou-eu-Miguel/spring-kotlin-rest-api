package br.imd.kotlinApi.kotlinapi.anime.resource

import br.imd.kotlinApi.kotlinapi.anime.dao.AnimeDao
import br.imd.kotlinApi.kotlinapi.anime.model.Anime
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/animes", produces = arrayOf("application/json"))
class AnimeResource(private val animeDao :AnimeDao){

    @GetMapping
    fun listAll():List<Anime>? = animeDao.findAll()

    @PostMapping
    fun save(@Valid @RequestBody anime: Anime): Anime = animeDao.save(anime)

    @GetMapping("/{id}")
    fun getAnimeById(@PathVariable("id") animeId:Long):ResponseEntity<Anime> =
            animeDao.findById(animeId).map { anime -> ResponseEntity.ok(anime)}
                .orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun updateAnimeById(@PathVariable("id") animeId: Long, @Valid @RequestBody animeNew: Anime ):ResponseEntity<Anime> {
        return animeDao.findById(animeId).map { animeExisting ->

            val animeUpdated: Anime = animeExisting.copy(
                    name         =  animeNew.name,
                    chapters     =  animeNew.chapters,
                    description  =  animeNew.description
            )

            ResponseEntity.ok().body(animeDao.save(animeUpdated))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteAnimeById(@PathVariable("id") animeId: Long):ResponseEntity<Void> {
        return animeDao.findById(animeId).map { animeExisting ->
            animeDao.delete(animeExisting)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}