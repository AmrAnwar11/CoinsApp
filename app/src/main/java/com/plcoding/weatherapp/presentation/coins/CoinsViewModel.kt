package com.plcoding.weatherapp.presentation.coins

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.weatherapp.base.BaseState
import com.plcoding.weatherapp.data.utils.applyCommonSideEffects
import com.plcoding.weatherapp.domain.entities.CoinItem
import com.plcoding.weatherapp.domain.usecase.CoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase
) : ViewModel() {

    var coinsState = mutableStateOf(BaseState<MutableList<CoinItem>>())
        private set

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            coinsUseCase().collectLatest {
                coinsState.value = it.applyCommonSideEffects()
            }
        }
    }
}
