package com.anime.myanimelist.presentation

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anime.myanimelist.data.Anime
import com.anime.myanimelist.domain.entity.AnimeDetailDomain
import com.anime.myanimelist.presentation.adapter.AnimeAdapter
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView



@BindingAdapter("set_image")
fun setImage(imageView: ImageView, url: String?) {
    Glide.with(imageView).load(url).into(imageView)
}

@BindingAdapter("youtube_player_url")
fun setYoutubePlayer(youTubePlayerView: YouTubePlayerView, url: String?) {
    Log.d("youtube_player_url", "getTopAnime: ${url}")

    url?.let {
        youTubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo("DknvOzqQCTo", 0f)
            }
        })
    }

}

@BindingAdapter("set_visibility")
fun viewVisibility(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("text_view_visibility")
fun viewVisibility(view: TextView, text: String?) {
    view.visibility = if (text?.isEmpty() == false) View.VISIBLE else View.GONE
}

