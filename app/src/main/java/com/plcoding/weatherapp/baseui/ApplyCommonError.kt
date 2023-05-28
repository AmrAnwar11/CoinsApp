package com.plcoding.weatherapp.baseui

import android.widget.Toast
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.plcoding.weatherapp.R
import com.plcoding.weatherapp.baseui.components.TimeOutError
import com.plcoding.weatherapp.baseui.components.UNAuthorizationDialog
import com.plcoding.weatherapp.domain.exceptions.NetworkExceptions

@Composable
fun Throwable.ApplyCommonError(
    boxScope: BoxScope, onRetry: (() -> Unit)? = null
) {
    val context = LocalContext.current
    when (this) {

        is NetworkExceptions.ConnectionException -> {
            BaseError(error = R.string.error_connection, boxScope)
        }

        is NetworkExceptions.ServerException -> {
            BaseError(error = R.string.error_server, boxScope)
        }

        is NetworkExceptions.NotFoundException -> {
            BaseError(error = R.string.error_not_found, boxScope)
        }

        is NetworkExceptions.UnknownException -> {
            BaseError(error = R.string.error_unknown, boxScope)
        }

        is NetworkExceptions.CustomException -> {
            Toast.makeText(context, this.msg, Toast.LENGTH_LONG).show()
        }

        is NetworkExceptions.NeedActiveException -> {
            Toast.makeText(context, this.msg, Toast.LENGTH_LONG).show()
        }

        is NetworkExceptions.TimeoutException -> {

            if (onRetry != null) {
                TimeOutError(boxScope) { onRetry() }
            } else {
                BaseError(error = R.string.error_timeout, boxScope)
            }

        }

        is NetworkExceptions.AuthorizationException -> {
            UNAuthorizationDialog(
                title = R.string.text_alert,
                msg = R.string.un_auth,
                positiveTitle = R.string.ok,
                onPositive = {
                    // handle positive button click
                }
            )
        }

        else -> {
            BaseError(error = R.string.error_unknown, boxScope)
        }
    }
}