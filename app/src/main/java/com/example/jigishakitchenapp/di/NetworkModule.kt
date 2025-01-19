package com.example.jigishakitchenapp.di

import com.example.jigishakitchenapp.api.JigishaKitchenAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.intellij.lang.annotations.PrintFormat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("https://rariton.com/hotel/hotel/public/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun providesJigishaKitchenAPI(retrofit: Retrofit) : JigishaKitchenAPI{
        return retrofit.create(JigishaKitchenAPI::class.java)
    }
}