package com.furkanekiz.tmdbclient.presentation.movie

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.furkanekiz.tmdbclient.R
import com.furkanekiz.tmdbclient.databinding.FrMovieBinding
import com.furkanekiz.tmdbclient.presentation.di.Injector

class FRMovie : Fragment() {

    private lateinit var binding: FrMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fr_movie, container, false)



        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}