package com.weather.compose.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.compose.model.WeatherResponse
import com.weather.compose.service.WeatherAPIService
import kotlinx.coroutines.launch
import androidx.compose.runtime.State

class MainViewModel_1 : ViewModel() {

    private val service = WeatherAPIService.api

    private val _weatherResponse = mutableStateOf<WeatherResponse?>(null)
    val weatherResponse: State<WeatherResponse?> = _weatherResponse

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun getWeatherData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val result = service.getWeather(
                    city = TODO(),
                    apiKey = TODO(),
                    units = TODO()
                )
                _weatherResponse.value = result
            } catch (e: Exception) {
                _error.value = "Erro ao buscar dados: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}