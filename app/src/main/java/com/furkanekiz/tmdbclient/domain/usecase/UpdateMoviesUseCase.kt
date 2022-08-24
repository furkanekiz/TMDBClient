package com.furkanekiz.tmdbclient.domain.usecase

import com.furkanekiz.tmdbclient.data.model.movie.Movie
import com.furkanekiz.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}