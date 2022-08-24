package com.furkanekiz.tmdbclient.data.repository.tvshow.datasource

import com.furkanekiz.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}