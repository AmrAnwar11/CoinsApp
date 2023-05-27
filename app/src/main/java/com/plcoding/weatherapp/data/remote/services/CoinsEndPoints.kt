package com.plcoding.weatherapp.data.remote.services

import com.plcoding.weatherapp.domain.entities.CoinDetailsResponse
import com.plcoding.weatherapp.domain.entities.CoinItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinsEndPoints {

    @GET("coins")
    suspend fun getCoins(): MutableList<CoinItem>

    @GET("coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") id: String): CoinDetailsResponse
}