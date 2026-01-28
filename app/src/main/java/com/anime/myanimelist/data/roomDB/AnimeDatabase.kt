package com.anime.myanimelist.data.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anime.myanimelist.data.Anime

@Database(entities = [Anime::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

    abstract fun animeDao(): AnimeDao
}