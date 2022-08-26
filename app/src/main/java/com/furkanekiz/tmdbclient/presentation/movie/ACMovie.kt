package com.furkanekiz.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.furkanekiz.tmdbclient.R
import com.furkanekiz.tmdbclient.databinding.AcMovieBinding
import com.furkanekiz.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ACMovie : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: AcMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.ac_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            Log.i("MYTAG", it.toString())
        }
    }
}