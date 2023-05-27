package com.plcoding.weatherapp.data.di

import com.plcoding.weatherapp.data.remote.services.CoinsEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EndPointsModule {

    @Provides
    @Singleton
    fun provideAuthEndPoints(retrofit: Retrofit): CoinsEndPoints =
        retrofit.create(CoinsEndPoints::class.java)
}