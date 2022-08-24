package com.furkanekiz.tmdbclient.domain.repository

import com.furkanekiz.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}