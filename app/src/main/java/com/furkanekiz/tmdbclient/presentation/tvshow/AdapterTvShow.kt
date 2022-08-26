package com.furkanekiz.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.furkanekiz.tmdbclient.data.model.tvshow.TvShow
import com.furkanekiz.tmdbclient.databinding.ListItemBinding

class AdapterTvShow(): RecyclerView.Adapter<ViewHolderTvShow>() {

    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTvShow {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderTvShow(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderTvShow, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class ViewHolderTvShow(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow) {
        binding.tvTitle.text = tvShow.name
        binding.tvDescription.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}