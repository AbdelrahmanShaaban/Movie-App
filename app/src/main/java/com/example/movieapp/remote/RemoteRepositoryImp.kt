package com.example.movieapp.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteRepositoryImp(private val api: ServiceApi) : RemoteRepository {
    override suspend fun getApiMovie()=
       withContext(Dispatchers.IO){
            api.getApiMovie()
        }


}