package com.weather.compose.view


import com.weather.compose.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.weather.compose.model.CountryCode
import com.weather.compose.viewModel.WeatherViewModel

@Composable
fun WeatherCard(weatherViewModel: WeatherViewModel = viewModel())
{
    val title = "Weather Today"
    val cityWeather = weatherViewModel.citiesWeather.collectAsState().value

    // Fetching data from ViewModel
    LaunchedEffect(Unit) {
        weatherViewModel.loadWeatherForCities(
            listOf("Amsterdam", "Barcelona", "Lisbon"),
            "1a03ac2ebe3574faa807d45a045c57ab"
        )
    }

    Surface {
        //Column Global
        Column(modifier = Modifier.fillMaxSize()) {
            //Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$title",
                    color = Color.Blue
                )

                Spacer(modifier = Modifier.width(30.dp)) // espaço de 16dp
            }//Row - Title


            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(cityWeather) { cityWeather ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Row Into City: Flag + Name + Temperature
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            //Flag (Composable)
                            CountryFlag(cityWeather.countryCode.country)

                            //Column: City Name + Temperature
                            Column(
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Text(text = cityWeather.city, color = Color.Blue)
                                Text(
                                    text = "${cityWeather.main.temperature.toInt()} ºC",
                                    color = Color.DarkGray
                                )
                            }//Column: City Name + Temperature
                        }//Row Into City: Flag + Name + Temperature
                    }//Row List Cities
                }//City Itens
            }//LazyColumn
        }//Column Global
    }//Surface
}