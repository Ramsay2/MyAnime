package com.anime.myanimelist.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anime.myanimelist.databinding.ItemAnimeBinding
import com.anime.myanimelist.data.Anime
import com.anime.myanimelist.domain.entity.AnimeDetailDomain

class AnimeAdapter(
    private val onItemClick: (AnimeDetailDomain) -> Unit
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private val animeList = mutableListOf<AnimeDetailDomain>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int = animeList.size

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(anime: AnimeDetailDomain) {
            binding.data = anime
            binding.root.setOnClickListener { onItemClick(anime) }
        }
    }

    fun submitList(list: List<AnimeDetailDomain>) {
        Log.d("AnimeRepository_adap", "getTopAnime: ${list}")

        animeList.clear()
        animeList.addAll(list)
        notifyDataSetChanged()
    }
}
