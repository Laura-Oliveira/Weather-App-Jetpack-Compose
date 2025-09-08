package com.weather.compose.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient
{
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val api: ServiceAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceAPI::class.java)
    }
}