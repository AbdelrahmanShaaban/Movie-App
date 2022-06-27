package com.example.movieapp.remote

import com.example.movieapp.model.Movie
import retrofit2.Response

interface RemoteRepository {
    suspend fun getApiMovie() : Response<List<Movie>>
}