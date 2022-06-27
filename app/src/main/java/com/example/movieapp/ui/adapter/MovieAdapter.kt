package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.GetImageURL
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import kotlinx.coroutines.withContext

class MovieAdapter:RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movies : List<Movie> = emptyList()
    fun setMoviesList(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie , parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int ) {

       var movie:Movie? =movies.get(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    override fun getItemCount() = movies.size

    class MovieViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        fun bind(movie: Movie){
            itemView.run {
                val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                var name = findViewById<TextView>(R.id.movieNameTextView)
                var productDate = findViewById<TextView>(R.id.productDateTextView)
                var rate = findViewById<TextView>(R.id.movieRateTextView)
                var movieImageView = findViewById<ImageView>(R.id.movieImageView)
                name.text = movie.title
                productDate.text = movie.release_date
                rate.text = movie.vote_average.toString()
                Glide.with(this).load(GetImageURL.getImageFullURL(movie.poster_path.toString()))
                    .fitCenter()
                    .apply(requestOptions)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(movieImageView)
            }
        }


    }
}