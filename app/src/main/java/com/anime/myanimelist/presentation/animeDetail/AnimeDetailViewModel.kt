package com.anime.myanimelist.presentation.animeDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anime.myanimelist.domain.AnimeDetailsRepository
import com.anime.myanimelist.domain.util.Response
import com.anime.myanimelist.domain.entity.AnimeDetailDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val repository: AnimeDetailsRepository
) : ViewModel() {

    private val _animeDetail = MutableLiveData<AnimeDetailDomain>()
    val animeDetail: LiveData<AnimeDetailDomain> get() = _animeDetail

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    fun fetchAnimeDetail(animeId: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getTopAnime(animeId).collect { result ->
                when (result) {
                    is Response.Success -> {
                        _animeDetail.value = result.data
                        _isLoading.value = false
                        Log.d("AnimeRepository_view", "getTopAnime: ${result.data}")
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