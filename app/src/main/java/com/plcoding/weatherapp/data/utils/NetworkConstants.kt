package com.plcoding.weatherapp.data.utils

object NetworkConstants {
    const val NETWORK_TIMEOUT: Long = 600000000
    const val API_VERSION = "/v1/"
}

object FailRequestCode {
    const val FAIL = 400
    const val UN_AUTH = 419
    const val BLOCKED = 423
    const val EXCEPTION = 500
}