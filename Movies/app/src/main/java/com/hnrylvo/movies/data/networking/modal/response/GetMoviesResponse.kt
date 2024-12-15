package com.hnrylvo.movies.data.networking.modal.response

import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("results")
    val results: List<MovieResponse>,
)

data class MovieResponse(
    @SerializedName("original_title")
    val movieTitle: String,
    @SerializedName("overview")
    val movieDescription: String,
    @SerializedName("poster_path")
    val imageUrl: String,
)