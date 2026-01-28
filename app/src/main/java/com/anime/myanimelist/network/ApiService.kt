package com.anime.myanimelist.network

import com.anime.myanimelist.data.AnimeDetailResponse
import com.anime.myanimelist.data.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("top/anime")
    suspend fun getTopAnime(): AnimeListResponse

    @GET("anime/{id}")
    suspend fun getAnimeDetails(@Path("id") animeId: Int): AnimeDetailResponse
}