package com.weather.compose.view

import com.weather.compose.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.weather.compose.viewModel.WeatherViewModel
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.background))
            ) {

            //Column Global
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = colorResource(R.color.square))
            ) {
                //Title
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.cat_weather),
                        contentDescription = "Icon App",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(50.dp))
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = "$title",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
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
                                    Text(
                                        text = cityWeather.city,
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = "${cityWeather.main.temperature.toInt()} ºC",
                                        color = Color.White,
                                        fontSize = 16.sp
                                    )
                                }//Column: City Name + Temperature
                            }//Row Into City: Flag + Name + Temperature
                        }//Row List Cities
                    }//City Itens
                }//LazyColumn
            }//Column Global
        }
    }//Surface
}