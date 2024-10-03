package com.alemicode.bitcoindemoapp.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.alemicode.bitcoindemoapp.ui.theme.GradientColors
import com.alemicode.bitcoindemoapp.ui.theme.LocalGradientColors
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme


@Composable
fun ApplicationBackground(): Brush{
    return Brush.linearGradient(
        colors = listOf(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.primary,
        )
    )

}
