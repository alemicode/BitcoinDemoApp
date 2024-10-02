package com.alemicode.bitcoindemoapp.ui.walletsList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WalletsListScreen(
    modifier: Modifier = Modifier,
    onWalletAddressClicked: (String) -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()
    ) {
        Button(onClick = { onWalletAddressClicked("tb1qtzrhlwxqcsufs8hvg4c3w33utf9hat4x9xlrf7") }) {
            Text("Click on me")
        }
    }
}