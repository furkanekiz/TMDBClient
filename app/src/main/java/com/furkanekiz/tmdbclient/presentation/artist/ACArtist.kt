package com.furkanekiz.tmdbclient.presentation.artist

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
import com.furkanekiz.tmdbclient.databinding.AcArtistBinding
import com.furkanekiz.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ACArtist : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: AcArtistBinding
    lateinit var adapterArtist: AdapterArtist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.ac_artist)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvArtist.layoutManager = LinearLayoutManager(this)
        adapterArtist = AdapterArtist()
        binding.rvArtist.adapter = adapterArtist
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.pbArtist.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this) {
            if (it != null) {
                adapterArtist.setList(it)
                adapterArtist.notifyDataSetChanged()
                binding.pbArtist.visibility = View.GONE
            } else {
                binding.pbArtist.visibility = View.GONE
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
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists() {
        binding.pbArtist.visibility = View.VISIBLE
        val response = artistViewModel.updateArtistList()
        response.observe(this) {
            if (it != null) {
                adapterArtist.setList(it)
                adapterArtist.notifyDataSetChanged()
                binding.pbArtist.visibility = View.GONE
            } else {
                binding.pbArtist.visibility = View.GONE
            }
        }
    }
}