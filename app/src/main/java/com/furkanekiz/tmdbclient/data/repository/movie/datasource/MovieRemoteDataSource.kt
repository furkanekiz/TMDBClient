package com.furkanekiz.tmdbclient.data.repository.movie.datasource

import com.furkanekiz.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}