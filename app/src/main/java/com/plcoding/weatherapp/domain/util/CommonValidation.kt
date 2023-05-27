package com.plcoding.weatherapp.domain.util

import java.util.regex.Pattern

object CommonValidation {

    fun String?.isValidPhone(): Boolean {
        return this?.isNotEmpty() == true && this.length >= 8
    }

    fun String?.isValidName(): Boolean {
        return this?.isNotEmpty() == true && this.length >= 3
    }

    fun String?.isValidText(): Boolean {
        return this?.isNotEmpty() == true && this.length >= 3
    }

    fun String?.isValidPassword(): Boolean {
        return this?.isNotEmpty() == true && this.length >= 6
    }

    fun String?.isValidPrice(): Boolean {
        return this?.isNotEmpty() == true
    }

    fun String?.isValidConfirmPassword(password: String): Boolean {
        return this?.isNotEmpty() == true && this == password
    }

    fun String?.isValidEmailAddress(): Boolean {
        val regex: Pattern = Pattern.compile(
            "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+.+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
//            "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+",
            Pattern.CASE_INSENSITIVE
        )
        return regex.matcher(this.toString()).matches()
    }

    fun String?.isValidCountryIso(): Boolean {
        return !this.isNullOrEmpty()
    }

    fun String?.isValidDeviceId(): Boolean {
        return !this.isNullOrEmpty()
    }

    fun String?.isValidLength(length: Int): Boolean {
        return this!!.length == length
    }

    fun String?.isValidConfirmationCode(): Boolean {
        return this?.isNotEmpty() == true && this.length >= 4
    }

    fun String.isValidNumber(): Boolean {
        return this.isNotEmpty()
    }

    fun String.isValidLink(): Boolean {
        val regex: Pattern =
            Pattern.compile(
                "^((ftp|http|https):\\/\\/)?(www.)?(?!.*(ftp|http|https|www.))[a-zA-Z0-9_-]+(\\.[a-zA-Z]+)+((\\/)[\\w#]+)*(\\/\\w+\\?[a-zA-Z0-9_]+=\\w+(&[a-zA-Z0-9_]+=\\w+)*)?$",
                Pattern.CASE_INSENSITIVE
            )
        return regex.matcher(this).matches()
    }

}