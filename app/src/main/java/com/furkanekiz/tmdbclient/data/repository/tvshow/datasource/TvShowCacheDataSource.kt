package com.furkanekiz.tmdbclient.data.repository.tvshow.datasource

import com.furkanekiz.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}