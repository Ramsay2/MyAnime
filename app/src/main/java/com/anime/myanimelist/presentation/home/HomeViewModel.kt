package com.anime.myanimelist.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.myanimelist.domain.AnimeRepository
import com.anime.myanimelist.domain.util.Response
import com.anime.myanimelist.domain.entity.AnimeDetailDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _animeList = MutableLiveData<List<AnimeDetailDomain>>()
    val animeList: LiveData<List<AnimeDetailDomain>> = _animeList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun getTopAnime() {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getTopAnime().collect { result ->
                when (result) {
                    is Response.Success -> {
                        _animeList.value = result.data ?: emptyList()
                        Log.d("AnimeRepository_view", "getTopAnime: ${result.data}")
                        _isLoading.value = false
                    }

                    is Response.Error -> {
                        _error.value = result.message ?: "Something went wrong"
                        _isLoading.value = false
                    }

                }
            }
        }

    }
}