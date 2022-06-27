package com.example.movieapp.model

data class Movie (
    var adult: Boolean ,
    var backdrop_path: String ,
    var genre_ids: List<Integer> ,
    var id : Int ,
    var original_language : String ,
    var original_title : String ,
    var overview: String,
    var popularity: Float,
    var poster_path: String?,
    var release_date: String,
    var title: String,
    var video: Boolean,
    var vote_average: Float,
    var vote_count: Int
    )