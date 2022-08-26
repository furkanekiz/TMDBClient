package com.furkanekiz.tmdbclient.presentation.di.artist

import com.furkanekiz.tmdbclient.domain.usecase.GetArtistsUseCase
import com.furkanekiz.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.furkanekiz.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}