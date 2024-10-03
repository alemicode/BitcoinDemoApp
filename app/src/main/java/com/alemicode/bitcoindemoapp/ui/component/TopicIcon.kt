package com.alemicode.bitcoindemoapp.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alemicode.bitcoindemoapp.R
import com.alemicode.bitcoindemoapp.ui.component.image.DynamicAsyncImage

@Composable
fun TopicIcon(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    DynamicAsyncImage(
        placeholder = painterResource(R.drawable.placeholder),
        imageUrl = imageUrl,
        // decorative
        contentDescription = null,
        modifier = modifier
            .padding(10.dp)
            .size(32.dp),
    )
}

