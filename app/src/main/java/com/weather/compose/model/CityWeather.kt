package com.weather.compose.model

import com.google.gson.annotations.SerializedName

data class CityWeather(
    @SerializedName("name") val city: String = "",
    @SerializedName("main") val main: Main,
    @SerializedName("sys") val countryCode:CountryCode
)

data class Main(
    @SerializedName("temp") val temperature: Double = 0.0
)

data class CountryCode(
    @SerializedName("country") val country:String = ""
)