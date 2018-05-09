package br.imd.kotlinApi.kotlinapi.anime.model

data class Anime(
    val name:           String,
    val description:    String,
    val chapters:       List<Chapter>
)