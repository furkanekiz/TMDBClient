package com.furkanekiz.tmdbclient.presentation.di.tvshow

import com.furkanekiz.tmdbclient.presentation.tvshow.ACTvShow
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(acTvShow: ACTvShow)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}