package com.anime.myanimelist.data.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anime.myanimelist.data.Anime
import kotlinx.coroutines.flow.Flow


@Dao
interface AnimeDao {
    @Query("SELECT * FROM anime")
    fun getAllAnime(): Flow<List<Anime>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeList(anime: List<Anime>)

    @Query("SELECT * FROM anime WHERE mal_id = :id")
    suspend fun getAnimeById(id: Int): Anime?
}