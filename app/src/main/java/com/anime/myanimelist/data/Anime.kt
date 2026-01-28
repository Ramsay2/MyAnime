package com.anime.myanimelist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class Anime(
    @PrimaryKey val mal_id: Int,
    val title: String,
    val episodes: Int?,
    val image: String,
    val rating: Double,
    val trailerUrl: String?,
    val youtubeId: String?,
    val genres: String?
)
