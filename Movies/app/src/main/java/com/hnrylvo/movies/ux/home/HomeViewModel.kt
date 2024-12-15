package com.hnrylvo.movies.ux.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hnrylvo.inmomarket.data.utils.onFailure
import com.hnrylvo.inmomarket.data.utils.onSuccess
import com.hnrylvo.movies.data.networking.modal.response.MovieResponse
import com.hnrylvo.movies.data.repository.MovieRepository
import com.hnrylvo.movies.data.utils.ApiConstants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val movieRepository = MovieRepository()

    private val _movies = MutableStateFlow<List<MovieResponse>>(emptyList())
    val movies = _movies.asStateFlow()

    val isLoading = mutableStateOf(false)

    fun getMovies() {
        isLoading.value = true
        viewModelScope.launch {
            movieRepository.getMovies(apiKey = ApiConstants.API_KEY).collectLatest { response ->
                response.onSuccess {  apiMovieList ->
                    Log.d("HomeViewModel", "Movies: ${apiMovieList.results}")
                    _movies.update { apiMovieList.results }
                }
                response.onFailure {
                    Log.e("HomeViewModel", "Error: ${it.throwable.message}")
                }
                isLoading.value = false
            }
        }
    }
}