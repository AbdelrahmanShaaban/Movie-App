package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.repositoryModule
import com.example.movieapp.di.serviceApiModule
import com.example.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieAPP : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MovieAPP)
            modules(
                    listOf(
                        viewModelModule,
                        repositoryModule,
                        serviceApiModule
                    )
            )
        }



    }
}