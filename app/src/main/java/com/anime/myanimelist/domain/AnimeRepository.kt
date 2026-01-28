package com.anime.myanimelist.domain

import android.util.Log
import com.anime.myanimelist.network.ApiService
import com.anime.myanimelist.data.roomDB.AnimeDao
import com.anime.myanimelist.domain.entity.AnimeDetailDomain
import com.anime.myanimelist.domain.mapper.toAnime
import com.anime.myanimelist.domain.mapper.toAnimeDetail
import com.anime.myanimelist.domain.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AnimeRepository @Inject constructor(
    private val api: ApiService
) {

    fun getTopAnime(): Flow<Response<List<AnimeDetailDomain>>> = flow {
        try {
            val response = api.getTopAnime()
            val domainData = response.data.map { it.toAnimeDetail() }

            emit(Response.Success(domainData))
        } catch (e: Exception) {
            emit(Response.Error(e.message.toString()))
        }
    }
}