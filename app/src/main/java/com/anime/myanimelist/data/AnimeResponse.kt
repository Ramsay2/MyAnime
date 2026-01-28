package com.anime.myanimelist.data

import com.google.gson.annotations.SerializedName


data class AnimeDetailResponse(
    @SerializedName("data")
    val data: AnimeResponse
)

data class AnimeResponse(
    @SerializedName("mal_id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("score")
    val rating: Double,
    @SerializedName("images")
    val images: AnimeImages,
    @SerializedName("trailer")
    val trailer: Trailer?,
    @SerializedName("genres")
    val genres: List<Genres>?,
)

data class Genres(
    @SerializedName("name")
    val genre: String
)


data class AnimeImages(
    @SerializedName("jpg")
    val jpg: ImageUrls
)

data class ImageUrls(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("small_image_url")
    val smallImageUrl: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String
)

data class Trailer(
    @SerializedName("youtube_id")
    val youtubeId: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("embed_url")
    val embedUrl: String?
)

