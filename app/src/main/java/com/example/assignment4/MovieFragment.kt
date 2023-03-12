package com.example.assignment4

import MovieData
import MovieList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MovieFragment(movie: MovieData) : Fragment() {

    private val item = movie
    private val images = MovieList().getImageData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_movie, container, false)
        val title = view.findViewById<TextView>(R.id.movie_title)
        val rating = view.findViewById<TextView>(R.id.rating)
        val desc = view.findViewById<TextView>(R.id.movie_info)
        val poster = view.findViewById<ImageView>(R.id.movie_image)

        title.text = item.title
        ("Rating: "+ item.vote_average.toString() +"/10").also { rating.text = it }
        desc.text = item.overview
        poster.setImageResource(images[item.title]!!)
        return view
    }
}