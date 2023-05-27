package com.plcoding.weatherapp.domain.entities

import com.squareup.moshi.Json

data class TeamItem(
    @Json(name = "name") val name: String? = null,
    @Json(name = "id") val id: String? = null,
    @Json(name = "position") val position: String? = null
)
