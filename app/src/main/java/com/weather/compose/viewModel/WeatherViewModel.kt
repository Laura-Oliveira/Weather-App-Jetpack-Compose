package com.weather.compose.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WeatherViewModel: ViewModel()
{
    //Encapsulamento
    //Disponibilizo o dado real através de outra variável,
    //visando proteger a fonte do dado, e o dado em si
    //Manipula o valor privado dentro da viewModel
    //Disponibiliza o valor como constante de forma publico
    //evitando que o resultado do processamento sa viewModel seja alterado
    private var _cityName = MutableStateFlow("Barcelona")
    val cityName: StateFlow<String> = _cityName

    private var _temperature = MutableStateFlow(25)
    val temperature: StateFlow<Int> = _temperature

    fun updateWeather(newCity:String, newTemp:Int)
    {
        _cityName.value = newCity
        _temperature.value = newTemp
    }
}