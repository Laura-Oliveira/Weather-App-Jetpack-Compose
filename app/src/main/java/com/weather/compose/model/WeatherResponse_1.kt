package com.weather.compose.model

data class WeatherResponse_1(
    val title: String,
    val consolidatedWeather: List<ConsolidatedWeather>
)

data class ConsolidatedWeather(
    val theTemp: Float,
    val weatherStateName: String,
    val humidity: Int
)