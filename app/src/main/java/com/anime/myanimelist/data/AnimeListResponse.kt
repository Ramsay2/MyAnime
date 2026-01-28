package com.anime.myanimelist.data

import com.google.gson.annotations.SerializedName

data class AnimeListResponse(
    @SerializedName("data")
    val data: List<AnimeResponse>
)