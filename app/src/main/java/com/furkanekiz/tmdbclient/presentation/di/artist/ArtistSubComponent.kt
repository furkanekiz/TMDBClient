package com.furkanekiz.tmdbclient.presentation.di.artist

import com.furkanekiz.tmdbclient.presentation.artist.ACArtist
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(acArtist: ACArtist)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }
}