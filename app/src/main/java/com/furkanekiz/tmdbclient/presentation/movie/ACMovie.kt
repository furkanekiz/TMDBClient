package com.furkanekiz.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.furkanekiz.tmdbclient.R
import com.furkanekiz.tmdbclient.databinding.AcMovieBinding
import com.furkanekiz.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ACMovie : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: AcMovieBinding
    lateinit var adapterMovie: AdapterMovie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.ac_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        adapterMovie = AdapterMovie()
        binding.rvMovie.adapter = adapterMovie
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.pbMovie.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            if (it != null) {
                adapterMovie.setList(it)
                adapterMovie.notifyDataSetChanged()
                binding.pbMovie.visibility = View.GONE
            } else {
                binding.pbMovie.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.pbMovie.visibility = View.VISIBLE
        val response = movieViewModel.updateMovieList()
        response.observe(this) {
            if (it != null) {
                adapterMovie.setList(it)
                adapterMovie.notifyDataSetChanged()
                binding.pbMovie.visibility = View.GONE
            } else {
                binding.pbMovie.visibility = View.GONE
            }
        }
    }
}