package com.plcoding.weatherapp.domain.usecase

import com.plcoding.weatherapp.domain.entities.BaseResponse
import com.plcoding.weatherapp.domain.entities.CoinItem
import com.plcoding.weatherapp.domain.exceptions.NetworkExceptions
import com.plcoding.weatherapp.domain.exceptions.ValidationException
import com.plcoding.weatherapp.domain.repository.CoinsRepository
import com.plcoding.weatherapp.domain.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeUseCase @Inject constructor(private val coinsRepository: CoinsRepository) {

    suspend operator fun invoke(): Flow<DataState<BaseResponse<MutableList<CoinItem>>>> = flow {

        emit(DataState.Loading)
        delay(2000)
        emit(DataState.Error(throwable = ValidationException.InValidEmailAddressException))

        // not handel in screen delay(2000)
        delay(2000)
        emit(DataState.Loading)
        delay(2000)
        emit(DataState.Error(throwable = ValidationException.InValidBankNameException))

        delay(2000)
        emit(DataState.Loading)
        delay(2000)
        emit(DataState.Error(throwable = NetworkExceptions.ConnectionException))

        delay(2000)
        emit(DataState.Loading)
        delay(2000)
        emit(DataState.Error(throwable = NetworkExceptions.NotFoundException))

        delay(2000)
        emit(DataState.Loading)
        delay(2000)
        emit(DataState.Error(throwable = NetworkExceptions.CustomException("this is CustomException from Api \uD83D\uDE0B")))

        delay(2000)
        emit(DataState.Loading)
        delay(2000)
        emit(DataState.Error(throwable = NetworkExceptions.AuthorizationException))

        delay(2000)
        emit(DataState.Loading)
        delay(2000)
        emit(DataState.Error(throwable = NetworkExceptions.TimeoutException))

    }
}