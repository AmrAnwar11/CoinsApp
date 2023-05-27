package com.plcoding.weatherapp.baseui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.plcoding.weatherapp.presentation.ui.theme.ColorPrimary

@Composable
fun BaseProgress(isLoading: Boolean) {
    if (isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x33000000))
        ) {
            CircularProgressIndicator(
                color = ColorPrimary,
                strokeWidth = 6.dp,
                modifier = Modifier.size(60.dp)

            )
        }
    }
}