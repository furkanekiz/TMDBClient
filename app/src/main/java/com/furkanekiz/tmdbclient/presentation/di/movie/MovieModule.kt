package com.furkanekiz.tmdbclient.presentation.di.movie

import com.furkanekiz.tmdbclient.domain.usecase.GetMoviesUseCase
import com.furkanekiz.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.furkanekiz.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}