package com.weather.compose.service

import com.weather.compose.model.WeatherResponse
import retrofit2.http.Query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherAPI_1 {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}

//object WeatherAPIService {
//    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
//
//    val api: WeatherAPI by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(WeatherAPI::class.java)
//    }
//}