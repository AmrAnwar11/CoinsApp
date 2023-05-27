package com.plcoding.weatherapp.data.di

import com.plcoding.weatherapp.data.repository.CoinsRepositoryImpl
import com.plcoding.weatherapp.domain.datasource.CoinsDataSource
import com.plcoding.weatherapp.domain.repository.CoinsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(coinsDataSource: CoinsDataSource): CoinsRepository =
        CoinsRepositoryImpl(coinsDataSource)
}