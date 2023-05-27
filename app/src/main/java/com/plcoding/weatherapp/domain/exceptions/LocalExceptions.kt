package com.plcoding.weatherapp.domain.exceptions

sealed class LocalExceptions : Exception() {
    object UnknownException : LocalExceptions()
    object TimeoutException : LocalExceptions()
}