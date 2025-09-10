package com.weather.compose.model

import com.weather.compose.service.RetrofitClient

class WeatherRepository
{
    private val api = RetrofitClient.api

//    suspend fun fetchWeather(): WeatherResponse
//    {
//        return api.getWeather()
//    }
//
    suspend fun fetchWeather(city: String, apiKey:String): CityWeather
    {
        return api.getWeather(city, apiKey)
    }

    suspend fun fetchWeatherForCities(cities: List<String>, apiKey: String): List<CityWeather> {
        return cities.mapNotNull { city ->
            try {
                val response = fetchWeather(city, apiKey)
                CityWeather(
                    city = response.city,
                    main = response.main
                )
            } catch (e: Exception) {
                null // ignora erros de cidades que falharem
            }
        }
    }
}