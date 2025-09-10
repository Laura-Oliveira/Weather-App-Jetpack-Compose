package com.weather.compose.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CountryFlag(countryCode: String)
{
    val url = "https://flagcdn.com/w40/${countryCode.lowercase()}.png"

    AsyncImage(
        model = url,
        contentDescription = "Flag $countryCode",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Blue, CircleShape)
    )
}