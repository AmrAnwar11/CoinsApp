package com.plcoding.weatherapp.presentation.coins

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.weatherapp.base.Screen
import com.plcoding.weatherapp.baseui.BaseError
import com.plcoding.weatherapp.baseui.BaseProgress
import com.plcoding.weatherapp.presentation.coins.components.CoinItem

@Composable
fun CoinsScreen(
    navController: NavController,
    viewModel: CoinsViewModel = hiltViewModel(),
) {
    val coinsState = viewModel.coinsState.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(coinsState.data?.data ?: mutableListOf()) { coin ->
                CoinItem(
                    coinItem = coin,
                    onCoinClicked = {
                        navController.navigate(Screen.CoinDetailsScreen.route + "/${coin.id}")
                    }
                )
            }
        }
    }

    BaseError(error = coinsState.error)

    BaseProgress(isLoading = coinsState.isLoading)
}

