package com.weather.compose.View


import com.weather.compose.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun WeatherCard() {
    var cityName by remember { mutableStateOf("Barcelona") }
    var title: String = "Weather Today"

    Surface {

        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {

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
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
//            horizontalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.spain_flag),
                    contentDescription = "City Icon",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )

                Text(
                    text = "$cityName",
                    color = Color.Blue,
                    modifier = Modifier
                        .padding(10.dp)
//                    .fillMaxSize(1f)
                )
            }
        }
    }
}