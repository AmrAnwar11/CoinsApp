package com.plcoding.weatherapp.data.di

import com.plcoding.weatherapp.BuildConfig
import com.plcoding.weatherapp.data.utils.NetworkConstants.API_VERSION
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object StringsModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BaseUrl

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RemoteBaseUrl

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String = BuildConfig.BASE_URL

    @Provides
    @RemoteBaseUrl
    fun provideRemoteBaseUrl(@BaseUrl baseUrl: String): String = "$baseUrl${API_VERSION}"
}