package com.weather.compose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.compose.model.CityWeather
import com.weather.compose.model.CountryCode
import com.weather.compose.model.Main
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
//    private var _cityName = MutableStateFlow("Barcelona, Amsterdam, Lisbon") //Estado que pode ser modificado
//    val cityName: StateFlow<String> = _cityName //Estado disponibilizado apenas para a leitura na camada de View

//    private var _temperature = MutableStateFlow(0.0)
//    val temperature: StateFlow<Double> = _temperature

  //  private var _weatherList =  MutableStateFlow<List<CityWeather>>(emptyList())
 //   val weatherList: StateFlow<List<CityWeather>> = _weatherList

//    fun updateWeather(newCity:String, newTemp: Double)
//    {
//        _cityName.value = newCity
//        _temperature.value = newTemp
//    }

    private val repository = WeatherRepository()
    private val _citiesWeather = MutableStateFlow<List<CityWeather>>(emptyList())
    val citiesWeather: StateFlow<List<CityWeather>> = _citiesWeather

    fun loadWeatherForCities(cities: List<String>, apiKey: String) {
        viewModelScope.launch {
            val result = repository.fetchWeatherForCities(cities, apiKey)
            _citiesWeather.value = result
        }
    }

//    fun loadWeather(city:String, apiKey:String)
//    {
//        viewModelScope.launch {
//            try {
//                val response = repository.fetchWeather(city, apiKey)
////                _cityName.value = response.city
////                _temperature.value = response.main.temperature
//
////                _cityName.value = response.city.ifEmpty { "Desconhecida" }
////                _temperature.value = response.main.temperature
//
//                val item = CityWeather(
//                    city = response.city.ifEmpty { "Unkown" },
//                    main = Main(response.main.temperature),
//                    countryCode = CountryCode(response.countryCode.country.ifEmpty { "XX" })
//                )
//
//                _weatherList.value = _weatherList.value + item
//
//            }
//            catch (exception: Exception)
//            {
////                _cityName.value = "Error"
////                _temperature.value = 0.0
//
//                val errorItem = CityWeather(
//                    city = "Error" ,
//                    main = Main(temperature = 0.0),
//                    countryCode = CountryCode("XX")
//                )
//
//                _weatherList.value = _weatherList.value + errorItem
//            }
//        }
//    }
}























