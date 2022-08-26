package com.furkanekiz.tmdbclient.presentation.di.core

import com.furkanekiz.tmdbclient.data.db.ArtistDao
import com.furkanekiz.tmdbclient.data.db.MovieDao
import com.furkanekiz.tmdbclient.data.db.TvShowDao
import com.furkanekiz.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.furkanekiz.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.furkanekiz.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.furkanekiz.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.furkanekiz.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.furkanekiz.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}