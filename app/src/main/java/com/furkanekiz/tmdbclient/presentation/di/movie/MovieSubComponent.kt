package com.furkanekiz.tmdbclient.presentation.di.movie

import com.furkanekiz.tmdbclient.presentation.movie.ACMovie
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(acMovie: ACMovie)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}