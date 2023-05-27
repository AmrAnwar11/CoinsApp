package com.plcoding.weatherapp.data.repository

import com.plcoding.weatherapp.data.utils.safeApiCall
import com.plcoding.weatherapp.domain.datasource.CoinsDataSource
import com.plcoding.weatherapp.domain.entities.BaseResponse
import com.plcoding.weatherapp.domain.entities.CoinDetailsResponse
import com.plcoding.weatherapp.domain.entities.CoinItem
import com.plcoding.weatherapp.domain.repository.CoinsRepository
import com.plcoding.weatherapp.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinsRepositoryImpl @Inject constructor(private val coinsDataSource: CoinsDataSource) :
    CoinsRepository {

    override suspend fun getCoins(): Flow<DataState<BaseResponse<MutableList<CoinItem>>>> =
        safeApiCall {
            coinsDataSource.getCoins()
        }

    override suspend fun getCoinDetails(id: String): Flow<DataState<BaseResponse<CoinDetailsResponse>>> =
        safeApiCall {
            coinsDataSource.getCoinDetails(id)
        }
}