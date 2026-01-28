package com.anime.myanimelist.domain.mapper

import com.anime.myanimelist.data.Anime
import com.anime.myanimelist.domain.entity.AnimeDetailDomain
import com.anime.myanimelist.data.AnimeResponse

fun AnimeResponse.toAnimeDetail(): AnimeDetailDomain {
    return AnimeDetailDomain(
        id = id,
        title = title,
        synopsis = synopsis,
        episodes = episodes,
        rating = rating,
        imageUrl = images.jpg.imageUrl,
        trailerUrl = trailer?.embedUrl,
        youtubeId = trailer?.youtubeId,
        genres = genres?.joinToString(", ") { it.genre }
    )
}

fun AnimeDetailDomain.toAnime(): Anime {
    return Anime(
        mal_id = id,
        title = title,
        episodes = episodes,
        rating = rating,
        image = imageUrl,
        trailerUrl = trailerUrl,
        youtubeId = youtubeId,
        genres = genres
    )
}