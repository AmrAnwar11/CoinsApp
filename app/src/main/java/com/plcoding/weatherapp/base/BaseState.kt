package com.plcoding.weatherapp.base

import com.plcoding.weatherapp.domain.entities.BaseResponse

data class BaseState<T>(
    var isLoading: Boolean = false,
    var data: BaseResponse<T>? = null,
    var error: Int? = null,
)
