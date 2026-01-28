package com.sachin.animeseries.presentation.fragments.animeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.anime.myanimelist.databinding.FragmentAnimeDetailBinding
import com.anime.myanimelist.presentation.animeDetail.AnimeDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {

    private lateinit var binding: FragmentAnimeDetailBinding
    private val viewModel: AnimeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animeId =
            arguments?.getInt("animeId") ?: throw IllegalArgumentException("Anime ID is required")

        viewModel.fetchAnimeDetail(animeId)
        setBindingData()
    }

    private fun setBindingData() {
        viewModel.animeDetail.observe(viewLifecycleOwner) {
            binding.data = it
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.isLoading = it
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.youtubePlayerView.release()
    }
}