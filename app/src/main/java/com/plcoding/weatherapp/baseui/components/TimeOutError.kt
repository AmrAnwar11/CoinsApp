package com.plcoding.weatherapp.baseui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.plcoding.weatherapp.R

@Composable
fun TimeOutError(
    boxScope: BoxScope,
    onRetry: () -> Unit
) {
    boxScope.apply {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(Center)
        ) {
            Text(
                text = stringResource(id = R.string.error_timeout),
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(CenterHorizontally),

                onClick = {
                    onRetry()
                }

            ) {
                Text(stringResource(R.string.retry))

            }
        }


    }
}

