package com.furkanekiz.tmdbclient.data.repository.artist.datasource

import com.furkanekiz.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}