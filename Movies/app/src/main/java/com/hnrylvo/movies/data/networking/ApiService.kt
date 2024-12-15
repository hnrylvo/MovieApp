package com.hnrylvo.movies.data.networking

import com.hnrylvo.movies.data.networking.modal.response.GetMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Header("Authorization") apiKey: String,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false
    ): GetMoviesResponse
}