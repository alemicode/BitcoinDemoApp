package com.alemicode.bitcoindemoapp.ui.walletsList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alemicode.bitcoindemoapp.domain.encryption.WalletsAddressModel
import com.alemicode.bitcoindemoapp.domain.model.readWalletsFromRawFile
import com.alemicode.bitcoindemoapp.ui.component.ApplicationBackground
import com.alemicode.bitcoindemoapp.ui.component.IconToggleButton
import com.alemicode.bitcoindemoapp.ui.component.TopicIcon

@Composable
fun WalletsListScreen(
    modifier: Modifier = Modifier,
    walletsUiState: State<List<WalletsAddressModel>>,
    onWalletAddressClicked: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = ApplicationBackground()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        WalletsList(
            wallets = walletsUiState.value,
            onWalletAddressClicked = onWalletAddressClicked
        )
    }
}

@Composable
private fun WalletsList(
    wallets: List<WalletsAddressModel>,
    onWalletAddressClicked: (String) -> Unit
) {
    LazyColumn {
        items(wallets) { wallet ->
            WalletItem(
                walletAddress = wallet.walletAddress ?: "Unknown Wallet Address",
                // A temp link to test image loading from server using coil
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Bitcoin.svg/800px-Bitcoin.svg.png",
                onClick = onWalletAddressClicked
            )
        }
    }
}

@Composable
private fun WalletItem(
    walletAddress: String,
    imageUrl: String,
    onClick: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 75.dp)
            .padding(horizontal = 30.dp, vertical = 20.dp),
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.background,
        onClick = { onClick(walletAddress) },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(70.dp)
                .padding(horizontal = 12.dp)
        ) {
            TopicIcon(imageUrl = imageUrl)
            WalletAddressText(walletAddress = walletAddress, Modifier.weight(1f))
            IconToggleButton(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Check,
                        contentDescription = "",
                    )
                },
            )
        }

    }
}

@Composable
private fun WalletAddressText(walletAddress: String, modifier: Modifier) {
    Text(
        text = walletAddress,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onSurface,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = modifier
    )
}
