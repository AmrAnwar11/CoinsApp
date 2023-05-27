package com.plcoding.weatherapp.domain.usecase

import com.plcoding.weatherapp.domain.repository.CoinsRepository
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinsUseCase @Inject constructor(private val coinsRepository: CoinsRepository) {

    suspend operator fun invoke() = flow {
        emitAll(coinsRepository.getCoins())
    }
}