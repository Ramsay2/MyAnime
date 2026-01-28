package com.anime.myanimelist.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.anime.myanimelist.R
import com.anime.myanimelist.databinding.FragmentHomeBinding
import com.anime.myanimelist.presentation.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    val homeViewModel by viewModels<HomeViewModel>()
    lateinit var dataBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentHomeBinding.inflate(layoutInflater)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLoadingView()
        homeViewModel.getTopAnime()
        setRecyclerView()
    }

    fun setLoadingView() {
        homeViewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                dataBinding.loadingView.visibility = View.VISIBLE
                dataBinding.animeRecyclerView.visibility = View.GONE
            } else {
                dataBinding.loadingView.visibility = View.GONE
                dataBinding.animeRecyclerView.visibility = View.VISIBLE
            }
        }
    }

    fun setRecyclerView() {
        val animeAdapter = AnimeAdapter {
            findNavController().navigate(
                R.id.action_animeListFragment_to_animeDetailFragment,
                Bundle().apply {
                    putInt("animeId", it.id)
                }
            )
        }

        dataBinding.animeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = animeAdapter
        }

        homeViewModel.animeList.observe(viewLifecycleOwner) {
            animeAdapter.submitList(it)
        }
    }

}