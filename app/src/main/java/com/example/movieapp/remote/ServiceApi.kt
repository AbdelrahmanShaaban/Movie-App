package com.example.movieapp.remote

import com.example.movieapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {
    @GET("/3/movie/popular?api_key=a76446e572a67d3c409b0bf64a39bcb9")
    suspend fun getApiMovie(): Response<List<Movie>>
}