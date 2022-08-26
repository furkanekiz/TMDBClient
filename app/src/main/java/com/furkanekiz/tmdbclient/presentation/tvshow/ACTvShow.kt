package com.furkanekiz.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.furkanekiz.tmdbclient.R
import com.furkanekiz.tmdbclient.databinding.AcTvShowBinding
import com.furkanekiz.tmdbclient.presentation.di.Injector
import com.furkanekiz.tmdbclient.presentation.movie.AdapterMovie
import com.furkanekiz.tmdbclient.presentation.movie.MovieViewModel
import javax.inject.Inject

class ACTvShow : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: AcTvShowBinding
    lateinit var adapterTvShow: AdapterTvShow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.ac_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvTvShow.layoutManager = LinearLayoutManager(this)
        adapterTvShow = AdapterTvShow()
        binding.rvTvShow.adapter = adapterTvShow
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.pbTvShow.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this) {
            if (it != null) {
                adapterTvShow.setList(it)
                adapterTvShow.notifyDataSetChanged()
                binding.pbTvShow.visibility = View.GONE
            } else {
                binding.pbTvShow.visibility = View.GONE
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
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        binding.pbTvShow.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShowList()
        response.observe(this) {
            if (it != null) {
                adapterTvShow.setList(it)
                adapterTvShow.notifyDataSetChanged()
                binding.pbTvShow.visibility = View.GONE
            } else {
                binding.pbTvShow.visibility = View.GONE
            }
        }
    }
}