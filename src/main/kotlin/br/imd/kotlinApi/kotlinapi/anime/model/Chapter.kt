package br.imd.kotlinApi.kotlinapi.anime.model

import java.time.Duration

data class Chapter(
    val name:           String,
    val description:    String,
    val duration:       Duration
)