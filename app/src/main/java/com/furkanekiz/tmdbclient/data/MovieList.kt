package com.furkanekiz.tmdbclient.data


import com.furkanekiz.tmdbclient.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)