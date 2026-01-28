package com.anime.myanimelist.domain

import android.util.Log
import com.anime.myanimelist.domain.entity.AnimeDetailDomain
import com.anime.myanimelist.domain.mapper.toAnimeDetail
import com.anime.myanimelist.domain.util.Response
import com.anime.myanimelist.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AnimeDetailsRepository @Inject constructor(
    private val api: ApiService,
) {
    // Fetches top anime and updates local DB
    fun getTopAnime(animeId: Int): Flow<Response<AnimeDetailDomain>> = flow {
        try {
            val response = api.getAnimeDetails(animeId)

            Log.d("AnimeRepository", "getTopAnime: ${response.data.toAnimeDetail()}")
            emit(Response.Success(response.data.toAnimeDetail()))
        } catch (e: Exception) {
            emit(Response.Error(e.message.toString()))
        }
    }
}