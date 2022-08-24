package com.furkanekiz.tmdbclient.data.repository.artist.datasource

import com.furkanekiz.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}