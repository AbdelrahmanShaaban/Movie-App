package com.example.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.ui.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private val mMovieViewModel: MovieViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAllUsers()
        mMovieViewModel.movieApiLiveData.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG).show()
           if (it != null) {

                adapter = MovieAdapter()
                adapter.setMoviesList(it)
                binding.movieRecyclerView.adapter = adapter
                binding.movieRecyclerView.setHasFixedSize(true)
            }
        })

    }
    fun getAllUsers() {
        mMovieViewModel.getApiMovie()
    }

}