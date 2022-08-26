package com.furkanekiz.tmdbclient.presentation.di.tvshow

import com.furkanekiz.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.furkanekiz.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.furkanekiz.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}