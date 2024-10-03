package com.alemicode.bitcoindemoapp.ui.walletsList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alemicode.bitcoindemoapp.ui.component.ApplicationBackground
import com.alemicode.bitcoindemoapp.ui.component.TopicIcon

@Composable
fun WalletsListScreen(
    modifier: Modifier = Modifier,
    onWalletAddressClicked: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = ApplicationBackground()
            )
    ) {
        SingleTopicButton(
            modifier = modifier,
            walletAddress = "tb1qtzrhlwxqcsufs8hvg4c3w33utf9hat4x9xlrf7",
            // Dummy image to test only
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Bitcoin.svg/800px-Bitcoin.svg.png",
            onClick = onWalletAddressClicked
        )
    }

}


@Composable
private fun SingleTopicButton(
    modifier: Modifier = Modifier,
    walletAddress: String,
    imageUrl: String,
    onClick: (String) -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        color = MaterialTheme.colorScheme.background,
        onClick = {
            onClick(walletAddress)
        },

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 12.dp, end = 8.dp),
        ) {
            TopicIcon(imageUrl = imageUrl)
            Text(
                text = walletAddress,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(1f),
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}