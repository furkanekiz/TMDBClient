package com.furkanekiz.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.furkanekiz.tmdbclient.R
import com.furkanekiz.tmdbclient.databinding.AcHomeBinding
import com.furkanekiz.tmdbclient.presentation.artist.ACArtist
import com.furkanekiz.tmdbclient.presentation.movie.ACMovie
import com.furkanekiz.tmdbclient.presentation.tvshow.ACTvShow

class ACHome : AppCompatActivity() {

    private lateinit var binding: AcHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.ac_home)

        binding.btnMovies.setOnClickListener {
            val intent = Intent(this,ACMovie::class.java)
            startActivity(intent)
        }

        binding.btnTvShows.setOnClickListener {
            val intent = Intent(this,ACTvShow::class.java)
            startActivity(intent)
        }

        binding.btnArtists.setOnClickListener {
            val intent = Intent(this,ACArtist::class.java)
            startActivity(intent)
        }
    }
}