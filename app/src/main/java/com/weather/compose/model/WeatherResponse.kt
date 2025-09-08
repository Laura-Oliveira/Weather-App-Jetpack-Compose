package com.weather.compose.model

import com.google.gson.annotations.SerializedName

//data class WeatherResponse(val city:String, val temperature:Int, val apiKey: String)

data class WeatherResponse(
    @SerializedName("name") val city:String = "",
    @SerializedName("main")val main:Main)

data class Main(
    @SerializedName("temp") val temperature: Double = 0.0
)