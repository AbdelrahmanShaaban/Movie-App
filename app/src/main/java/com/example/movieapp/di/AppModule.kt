package com.example.movieapp.di

import com.example.movieapp.model.Repository
import com.example.movieapp.model.RepositoryImp
import com.example.movieapp.remote.RemoteRepository
import com.example.movieapp.remote.RemoteRepositoryImp
import com.example.movieapp.remote.RetrofitBuilder
import com.example.movieapp.remote.ServiceApi
import com.example.movieapp.ui.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseUrl : String= "https://api.themoviedb.org/"
val viewModelModule = module {
    viewModel {
        MovieViewModel(repository = get())
    }
}

val repositoryModule = module {
   single<RemoteRepository> {
        RemoteRepositoryImp(api = get())
   }
    single<Repository> {
        RepositoryImp(remoteRepository = get())
    }
}

val serviceApiModule = module {
    fun getRetrofitBuilder() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { getRetrofitBuilder() }
    fun getServiceApiInstance(retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

    single { getServiceApiInstance(retrofit = get()) }
}


