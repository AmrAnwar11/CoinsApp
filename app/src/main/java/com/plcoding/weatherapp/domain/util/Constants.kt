package com.plcoding.weatherapp.domain.util

import java.util.*

object Constants {
    val language: String
        get() {
            return Locale.getDefault().language
        }
    const val USER = "user"
}

object ResponseStatus {
    const val SUCCESS = "success"
    const val NEED_ACTIVATE = "needActive"
    const val FAILED = "fail"
    const val ACTIVE = "active"
    const val NOT_ACTIVE = "waitingApproval"
    const val BLOCK = "blocked"
    const val PENDING = "pending"
    const val UN_AUTH = "unauthenticated"
    const val EXCEPTION = "exception"
}