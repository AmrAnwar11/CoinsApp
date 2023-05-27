package com.plcoding.weatherapp.domain.datasource

import com.plcoding.weatherapp.domain.entities.BaseResponse
import com.plcoding.weatherapp.domain.entities.CoinDetailsResponse
import com.plcoding.weatherapp.domain.entities.CoinItem

interface CoinsDataSource {

    suspend fun getCoins(): BaseResponse<MutableList<CoinItem>>

    suspend fun getCoinDetails(id: String): BaseResponse<CoinDetailsResponse>
}