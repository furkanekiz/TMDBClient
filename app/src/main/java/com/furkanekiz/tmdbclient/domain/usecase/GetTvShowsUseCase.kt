package com.furkanekiz.tmdbclient.domain.usecase

import com.furkanekiz.tmdbclient.data.model.tvshow.TvShow
import com.furkanekiz.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}