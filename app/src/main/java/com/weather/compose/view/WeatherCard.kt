package com.weather.compose.view


import com.weather.compose.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.weather.compose.viewModel.WeatherViewModel

@Composable
fun WeatherCard(
    weatherViewModel: WeatherViewModel = viewModel()
) {
    //Dados estaticos
    // var cityName by remember { mutableStateOf("Barcelona") }
    // var temperature by remember { mutableStateOf("") }
    val title = "Weather Today"

    //Dados provenientes ViewModel
    val cityName = weatherViewModel.cityName.collectAsState().value
    val temperature = weatherViewModel.temperature.collectAsState().value

//    var listCities:List<String> = { "Amsterdam, Barcelona, Lison"} as List<String>

 //   weatherViewModel.loadWeatherForCities(listCities, "1a03ac2ebe3574faa807d45a045c57ab")

//    LaunchedEffect(Unit) {
//        weatherViewModel.loadWeather(cityName, "1a03ac2ebe3574faa807d45a045c57ab")
//    }

    val cityWeather = weatherViewModel.citiesWeather.collectAsState().value

    // Buscar dados quando a tela abrir
    LaunchedEffect(Unit) {
        weatherViewModel.loadWeatherForCities(
            listOf("Amsterdam", "Barcelona", "Lisbon"),
            "1a03ac2ebe3574faa807d45a045c57ab"
        )
    }

    Surface {

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
                        // City + Flag + Temperature
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            // Flag
                            Image(
                                painter = painterResource(id = R.drawable.spain_flag),
                                contentDescription = "City Icon",
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                            )

                            //City Name + Temperature
                            Column(
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Text(text = cityWeather.city, color = Color.Blue)
                                Text(
                                    text = "${cityWeather.main.temperature.toInt()} ºC",
                                    color = Color.DarkGray
                                )
                            }
                        }
                    }
                }
            }
//        Column(
//            modifier = Modifier
//                .padding(10.dp),
//            verticalArrangement = Arrangement.SpaceAround
//        ) {
//            //Title
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = "$title",
//                    color = Color.Blue
//                )
//            }//Row - Title
//
//            // City + Flag + Temperature
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Start
//            ) {
//                // Flag
//                Image(
//                    painter = painterResource(id = R.drawable.spain_flag),
//                    contentDescription = "City Icon",
//                    modifier = Modifier
//                        .width(50.dp)
//                        .height(50.dp)
//                )
//
//                //City Name + Temperature
//                Column(
//                    modifier = Modifier.padding(start = 10.dp)
//                ) {
//                    Text(
//                        text = cityName,
//                        color = Color.Blue
//                    )
//                    Text(
//                        text = "${temperature.toInt() ?: 0.0} ºC",
//                        color = Color.DarkGray
//                    )
//                }//Column
//            }//Row
            //  }//Column
        }
    }//Surface
}