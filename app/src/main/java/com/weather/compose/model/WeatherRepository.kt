package com.weather.compose.model

import com.weather.compose.service.RetrofitClient
import retrofit2.Retrofit

class WeatherRepository
{
    private val api = RetrofitClient.api

//    suspend fun fetchWeather(): WeatherResponse
//    {
//        return api.getWeather()
//    }
//
    suspend fun fetchWeather(city: String, apiKey:String): WeatherResponse
    {
        return api.getWeather(city, apiKey)
    }
}