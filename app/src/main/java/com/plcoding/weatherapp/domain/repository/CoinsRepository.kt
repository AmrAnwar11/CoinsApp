package com.plcoding.weatherapp.domain.repository

import com.plcoding.weatherapp.domain.entities.BaseResponse
import com.plcoding.weatherapp.domain.entities.CoinDetailsResponse
import com.plcoding.weatherapp.domain.entities.CoinItem
import com.plcoding.weatherapp.domain.util.DataState
import kotlinx.coroutines.flow.Flow

interface CoinsRepository {

    suspend fun getCoins(): Flow<DataState<BaseResponse<MutableList<CoinItem>>>>

    suspend fun getCoinDetails(id: String): Flow<DataState<BaseResponse<CoinDetailsResponse>>>
}