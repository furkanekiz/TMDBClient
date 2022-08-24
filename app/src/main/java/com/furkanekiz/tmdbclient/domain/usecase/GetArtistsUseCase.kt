package com.furkanekiz.tmdbclient.domain.usecase

import com.furkanekiz.tmdbclient.data.model.artist.Artist
import com.furkanekiz.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}