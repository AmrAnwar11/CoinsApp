package com.plcoding.weatherapp.data.di

import com.plcoding.weatherapp.data.remote.datasource.CoinsDataSourceImpl
import com.plcoding.weatherapp.data.remote.services.CoinsEndPoints
import com.plcoding.weatherapp.domain.datasource.CoinsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourcesModule {

    @Provides
    @Singleton
    fun provideAuthRemoteDataSource(weatherEndPoints: CoinsEndPoints): CoinsDataSource =
        CoinsDataSourceImpl(weatherEndPoints)
}