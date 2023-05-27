package com.plcoding.weatherapp.domain.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    @Json(name = "status") val status: Boolean? = null,
    @Json(name = "message") val message: String? = null,
    @Json(name = "data") val data: T? = null
) : Serializable