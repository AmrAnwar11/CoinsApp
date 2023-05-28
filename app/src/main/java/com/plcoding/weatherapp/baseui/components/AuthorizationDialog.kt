package com.plcoding.weatherapp.baseui.components

import androidx.annotation.StringRes
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource


@Composable
fun UNAuthorizationDialog(
    @StringRes title: Int,
    @StringRes msg: Int,
    @StringRes positiveTitle: Int,
    onPositive: () -> Unit,

    ) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text(stringResource(title)) },
            text = { Text(stringResource(msg)) },
            confirmButton = {
                Button(
                    onClick = {
                        onPositive()
                        openDialog.value = false
                    }
                ) { Text(stringResource(positiveTitle)) }
            }

        )
    }

}




