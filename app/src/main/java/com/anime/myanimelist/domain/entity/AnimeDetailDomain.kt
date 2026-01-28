package com.anime.myanimelist.domain.entity

data class AnimeDetailDomain(
    val id: Int,
    val title: String,
    val synopsis: String,
    val episodes: Int,
    val rating: Double,
    val imageUrl: String,
    val trailerUrl: String?,
    val youtubeId : String?,
    val genres : String?,
)
