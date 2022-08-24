package com.furkanekiz.tmdbclient.domain.repository

import com.furkanekiz.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}