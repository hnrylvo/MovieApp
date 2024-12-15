package com.hnrylvo.movies.data.repository

import com.hnrylvo.movies.data.networking.ApiClient

class MovieRepository : BaseRepository() {
    private val apiService = ApiClient.apiService

    suspend fun getMovies(apiKey: String) = fetchData {
        apiService.getMovies(apiKey = apiKey)
    }
}