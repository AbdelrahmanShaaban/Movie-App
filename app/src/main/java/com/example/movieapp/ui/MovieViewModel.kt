package com.example.movieapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.model.Movie
import com.example.movieapp.model.Repository
import com.example.movieapp.remote.RemoteRepositoryImp
import kotlinx.coroutines.launch

class MovieViewModel(private var repository: Repository) : ViewModel() {

    private var movieApiMutableLiveData = MutableLiveData<List<Movie>>()
    val movieApiLiveData : LiveData<List<Movie>> get() = movieApiMutableLiveData

    fun getApiMovie () {
        viewModelScope.launch {
            var result = repository.getApiMovie()
            if (result.body() != null) {
                movieApiMutableLiveData.postValue(result.body())
            } else {
                Log.i("ErrorMsg", result.message())
            }
        }
    }
}