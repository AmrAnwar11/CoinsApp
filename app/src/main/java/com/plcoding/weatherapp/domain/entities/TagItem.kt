package com.plcoding.weatherapp.domain.entities

import com.squareup.moshi.Json

data class TagItem(
    @Json(name = "coin_counter") val coinCounter: Int? = null,
    @Json(name = "ico_counter") val icoCounter: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "id") val id: String? = null
)
