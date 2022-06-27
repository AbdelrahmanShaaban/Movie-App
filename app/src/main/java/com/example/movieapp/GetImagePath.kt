package com.example.movieapp

object GetImageURL {
    const val ImageBaseURL = "https://image.tmdb.org/t/p/w500/"

    fun getImageFullURL(imgExtensionPath: String) = ImageBaseURL + imgExtensionPath
}