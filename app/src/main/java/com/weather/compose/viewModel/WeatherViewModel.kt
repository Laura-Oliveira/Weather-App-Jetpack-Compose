package com.weather.compose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.compose.model.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class WeatherViewModel: ViewModel()
{
    //Encapsulamento
    //Disponibilizo o dado real através de outra variável,
    //visando proteger a fonte do dado, e o dado em si
    //Manipula o valor privado dentro da viewModel
    //Disponibiliza o valor como constante de forma publico
    //evitando que o resultado do processamento sa viewModel seja alterado
    private var _cityName = MutableStateFlow("Barcelona") //Estado que pode ser modificado
    val cityName: StateFlow<String> = _cityName //Estado disponibilizado apenas para a leitura na camada de View

    private var _temperature = MutableStateFlow(0.0)
    val temperature: StateFlow<Double> = _temperature

    private val repository = WeatherRepository()

    fun updateWeather(newCity:String, newTemp: Double)
    {
        _cityName.value = newCity
        _temperature.value = newTemp
    }

    fun loadWeather(city:String, apiKey:String)
    {
        viewModelScope.launch {
            try {
                val response = repository.fetchWeather(city, apiKey)
//                _cityName.value = response.city
//                _temperature.value = response.main.temperature

                _cityName.value = response.city.ifEmpty { "Desconhecida" }
                _temperature.value = response.main.temperature
            }
            catch (exception: Exception)
            {
                _cityName.value = "Error"
                _temperature.value = 0.0
            }
        }
    }
}























