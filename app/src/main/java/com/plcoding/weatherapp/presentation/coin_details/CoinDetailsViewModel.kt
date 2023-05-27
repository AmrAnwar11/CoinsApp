package com.plcoding.weatherapp.presentation.coin_details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.weatherapp.base.BaseState
import com.plcoding.weatherapp.data.utils.applyCommonSideEffects
import com.plcoding.weatherapp.domain.entities.CoinDetailsResponse
import com.plcoding.weatherapp.domain.entities.CoinItem
import com.plcoding.weatherapp.domain.usecase.CoinDetailsUseCase
import com.plcoding.weatherapp.domain.usecase.CoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val coinDetailsUseCase: CoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var detailsState = mutableStateOf(BaseState<CoinDetailsResponse>())
        private set

    init {
        savedStateHandle.get<String>("coinId")?.let { getCoinDetails(it) }
    }

    private fun getCoinDetails(id: String) {
        viewModelScope.launch {
            coinDetailsUseCase(id).collectLatest {
                detailsState.value = it.applyCommonSideEffects()
            }
        }
    }
}
