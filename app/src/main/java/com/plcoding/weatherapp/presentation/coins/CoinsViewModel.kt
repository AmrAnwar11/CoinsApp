package com.plcoding.weatherapp.presentation.coins

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.weatherapp.base.BaseState
import com.plcoding.weatherapp.data.utils.applyCommonSideEffects
import com.plcoding.weatherapp.domain.entities.CoinItem
import com.plcoding.weatherapp.domain.usecase.CoinsUseCase
import com.plcoding.weatherapp.domain.usecase.FakeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase,
    private val fakeUseCase: FakeUseCase
) : ViewModel() {

    var coinsState = mutableStateOf(BaseState<MutableList<CoinItem>>())
        private set

    init {
        fakeTest()
    }

    private fun fakeTest() {
        viewModelScope.launch {
            fakeUseCase().collectLatest {
                coinsState.value = it.applyCommonSideEffects()
            }
        }
    }

    fun getCoins() {
        viewModelScope.launch {
            coinsUseCase().collectLatest {
                coinsState.value = it.applyCommonSideEffects()
            }
        }
    }
}
