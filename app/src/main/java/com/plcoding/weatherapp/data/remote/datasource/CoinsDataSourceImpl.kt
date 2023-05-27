package com.plcoding.weatherapp.data.remote.datasource

import com.plcoding.weatherapp.data.remote.services.CoinsEndPoints
import com.plcoding.weatherapp.domain.datasource.CoinsDataSource
import com.plcoding.weatherapp.domain.entities.BaseResponse
import com.plcoding.weatherapp.domain.entities.CoinDetailsResponse
import com.plcoding.weatherapp.domain.entities.CoinItem
import javax.inject.Inject

class CoinsDataSourceImpl @Inject constructor(private val weatherEndPoints: CoinsEndPoints) :
    CoinsDataSource {

    override suspend fun getCoins(): BaseResponse<MutableList<CoinItem>> {
        return BaseResponse(
            data = weatherEndPoints.getCoins()
        )
    }

    override suspend fun getCoinDetails(id: String): BaseResponse<CoinDetailsResponse> {
        return BaseResponse(
            data = weatherEndPoints.getCoinDetails(id)
        )
    }
}