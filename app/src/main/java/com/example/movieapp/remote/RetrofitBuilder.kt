package com.example.movieapp.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

companion object{
    const val baseUrl : String= "https://api.themoviedb.org/"
    fun getRetrofitBuilder() : Retrofit{
     return Retrofit.Builder()
         .baseUrl(baseUrl)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
    }
}
}