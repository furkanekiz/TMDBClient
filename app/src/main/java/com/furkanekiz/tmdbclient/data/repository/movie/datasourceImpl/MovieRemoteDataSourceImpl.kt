package com.furkanekiz.tmdbclient.data.repository.movie.datasourceImpl

import com.furkanekiz.tmdbclient.data.api.TMDBService
import com.furkanekiz.tmdbclient.data.model.movie.MovieList
import com.furkanekiz.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}