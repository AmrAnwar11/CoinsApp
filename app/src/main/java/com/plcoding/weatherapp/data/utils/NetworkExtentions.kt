package com.plcoding.weatherapp.data.utils

import com.plcoding.weatherapp.base.BaseState
import com.plcoding.weatherapp.domain.entities.BaseResponse
import com.plcoding.weatherapp.domain.util.DataState

fun <T> DataState<BaseResponse<T>>.applyCommonSideEffects(onError: ((Throwable) -> BaseState<T>)? = null): BaseState<T> {
    return when (this) {
        is DataState.Loading -> {
            BaseState(isLoading = true)
        }

        is DataState.Error -> {
            BaseState(error = this.throwable)
        }

        is DataState.Success -> {
            BaseState(data = this.data)
        }

        else -> BaseState()
    }
}