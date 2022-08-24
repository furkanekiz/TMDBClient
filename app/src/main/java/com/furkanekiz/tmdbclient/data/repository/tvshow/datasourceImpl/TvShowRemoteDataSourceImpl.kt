package com.furkanekiz.tmdbclient.data.repository.tvshow.datasourceImpl

import com.furkanekiz.tmdbclient.data.api.TMDBService
import com.furkanekiz.tmdbclient.data.model.tvshow.TvShowList
import com.furkanekiz.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}