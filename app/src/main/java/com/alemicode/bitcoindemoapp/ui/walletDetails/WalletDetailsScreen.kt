package com.alemicode.bitcoindemoapp.ui.walletDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alemicode.bitcoindemoapp.ui.WalletInformationUiState
import com.alemicode.bitcoindemoapp.ui.component.CardComponent
import com.alemicode.bitcoindemoapp.ui.component.PullToRefreshLazyColumn
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WalletDetailsScreen(
    modifier: Modifier = Modifier,
    uiState: State<WalletInformationUiState>, // Passing State rather than  wrapping value to avoid recomposition
    refreshData: () -> Unit,
    walletAddress: String,
) {


    // Remember the coroutine scope for launching background tasks
    val coroutineScope = rememberCoroutineScope()

    // State for managing the refresh status
    var isRefreshing by remember { mutableStateOf(false) }


    Column(modifier = modifier.fillMaxSize()) {
        PullToRefreshLazyColumn(
            content = {
                // Display the appropriate content based on the UI state
                when (uiState.value) {

                    is WalletInformationUiState.Error -> {
                        val error = uiState.value as WalletInformationUiState.Error
                        Text(text = error.message)
                    }

                    WalletInformationUiState.Loading -> {
                        Box(

                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = MaterialTheme.colorScheme.surface)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .align(Alignment.Center) // Center the CircularProgressIndicator
                                    .padding(16.dp),
                            )
                        }
                    }

                    is WalletInformationUiState.Success -> {
                        val data = (uiState.value as WalletInformationUiState.Success).data
                        val btcAmount =
                            data.walletBalanceModel.totalFunded?.let {
                                (it / 10000)
                            } ?: 0
                        // LazyColumn with item padding and spacing
                        LazyColumn(
                            state = rememberLazyListState(),
                            contentPadding = PaddingValues(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            item {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 20.dp, end = 20.dp, top = 30.dp),
                                    text = "The wallet address is : ${walletAddress}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.Center,
                                )
                            }

                            item {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 20.dp),
                                    text = "The BTC amount is : $btcAmount",
                                    style = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.Center,
                                )
                            }

                            items(data.submittedTransactionHistoryModel) {
                                CardComponent(
                                    transactionId = it.transactionId ?: "Unknown",
                                    status = it.status,
                                    amount = it.amount ?: 0,
                                    walletAddress = ""
                                )
                            }

                            items(data.rejectedTransactionHistoryModel) {
                                CardComponent(
                                    transactionId = it.transactionId ?: "Unknown",
                                    status = it.status,
                                    amount = it.amount ?: 0,
                                    walletAddress = ""
                                )
                            }
                        }


                    }
                }

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


fun getResultText(uiState: WalletInformationUiState): String {
    return when (uiState) {
        is WalletInformationUiState.Error -> "Error"
        is WalletInformationUiState.Loading -> "Loading"
        is WalletInformationUiState.Success -> uiState.data.toString()
    }
}
