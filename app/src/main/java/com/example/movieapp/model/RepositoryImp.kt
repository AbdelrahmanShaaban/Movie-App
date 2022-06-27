package com.example.movieapp.model

import android.app.Application
import com.example.movieapp.remote.RemoteRepository
import retrofit2.Response

class RepositoryImp(private val remoteRepository: RemoteRepository) : Repository {
    override suspend fun getApiMovie() = remoteRepository.getApiMovie()
}