package com.weather.compose.service

import com.weather.compose.model.CityWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI
{
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): CityWeather
}