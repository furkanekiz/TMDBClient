package com.furkanekiz.tmdbclient.presentation.di

import com.furkanekiz.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.furkanekiz.tmdbclient.presentation.di.movie.MovieSubComponent
import com.furkanekiz.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}