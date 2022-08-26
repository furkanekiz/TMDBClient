package com.furkanekiz.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.furkanekiz.tmdbclient.data.model.artist.Artist
import com.furkanekiz.tmdbclient.data.model.movie.Movie
import com.furkanekiz.tmdbclient.databinding.ListItemBinding
import com.furkanekiz.tmdbclient.presentation.movie.ViewHolderMovie

class AdapterArtist() : RecyclerView.Adapter<ViewHolderArtist>() {
    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderArtist {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderArtist(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderArtist, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class ViewHolderArtist(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.tvTitle.text = artist.name
        binding.tvDescription.text = artist.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }
}