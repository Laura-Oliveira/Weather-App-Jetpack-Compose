package com.weather.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels              // Importação da extensão viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.weather.compose.View.WeatherCard
import com.weather.compose.ViewModel.MainViewModel

@Composable
fun WeatherAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography(),
        content = content
    )
}

class MainView : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Previsão do Tempo") },
                            colors = TopAppBarDefaults.mediumTopAppBarColors()
                        )
                    }
                ) { padding ->
                    val weather by viewModel.weatherResponse
                    Surface(
                        modifier = Modifier.padding(padding)
                    ) {
                        weather?.let { WeatherCard(it) }
                    }
                }
            }
        }
    }
}