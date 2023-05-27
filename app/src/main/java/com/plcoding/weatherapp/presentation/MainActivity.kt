package com.plcoding.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.weatherapp.base.Screen
import com.plcoding.weatherapp.presentation.coin_details.CoinDetailsScreen
import com.plcoding.weatherapp.presentation.coins.CoinsScreen
import com.plcoding.weatherapp.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinsScreen.route
                    ) {
                        composable(route = Screen.CoinsScreen.route) {
                            CoinsScreen(navController)
                        }

                        composable(route = Screen.CoinDetailsScreen.route + "/{coinId}") {
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}