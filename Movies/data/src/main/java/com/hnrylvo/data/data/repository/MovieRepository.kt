package com.hnrylvo.data.data.repository

import com.hnrylvo.data.data.networking.ApiClient

class MovieRepository : BaseRepository() {
    private val apiService = ApiClient.apiService

    suspend fun getMovies(apiKey: String) = fetchData {
        apiService.getMovies(apiKey = apiKey)
    }
}