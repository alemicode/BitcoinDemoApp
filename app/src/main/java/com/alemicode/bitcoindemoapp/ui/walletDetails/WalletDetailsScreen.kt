package com.alemicode.bitcoindemoapp.ui.walletDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alemicode.bitcoindemoapp.ui.WalletInformationUiState
import com.alemicode.bitcoindemoapp.ui.component.PullToRefreshLazyColumn
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WalletDetailsScreen(
    modifier: Modifier = Modifier,
    uiState: State<WalletInformationUiState>, // Passing State rather than  wrapping value to avoid recomposition
    refreshData: () -> Unit
) {
    // Remember the coroutine scope for launching background tasks
    val coroutineScope = rememberCoroutineScope()

    // State for managing the refresh status
    var isRefreshing by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            PullToRefreshLazyColumn(
                content = {
                    // Display the appropriate content based on the UI state
                    val resultText = getResultText(uiState.value)
                    Text(text = resultText, modifier = Modifier.padding(16.dp))
                },
                isRefreshing = isRefreshing,
                onRefresh = {
                    coroutineScope.launch {
                        isRefreshing = true
                        refreshData()
                        delay(3000)
                        isRefreshing = false
                    }
                }
            )
        }
    }
}

fun getResultText(uiState: WalletInformationUiState): String {
    return when (uiState) {
        is WalletInformationUiState.Error -> "Error"
        is WalletInformationUiState.Loading -> "Loading"
        is WalletInformationUiState.Success -> uiState.data.toString()
    }
}
