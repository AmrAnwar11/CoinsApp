package com.plcoding.weatherapp.domain.entities

import com.squareup.moshi.Json

data class CoinDetailsResponse(
    @Json(name = "id") val id: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "symbol") val symbol: String? = null,
    @Json(name = "rank") val rank: String? = null,
    @Json(name = "is_active") val isActive: Boolean? = null,
    @Json(name = "tags") val tags: MutableList<TagItem>? = null,
    @Json(name = "team") val team: MutableList<TeamItem>? = null
)