package com.plcoding.weatherapp.base

sealed class Screen(val route: String) {
    object CoinsScreen : Screen("coins")
    object CoinDetailsScreen : Screen("coin_details")
}
