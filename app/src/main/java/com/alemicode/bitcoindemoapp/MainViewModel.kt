package com.alemicode.bitcoindemoapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alemicode.bitcoindemoapp.domain.GetTransactionHistoryUseCase
import com.alemicode.bitcoindemoapp.domain.model.model.AllTransactionHistoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTransactionHistoryUseCase: GetTransactionHistoryUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Flow to hold the wallet address, with a default value
    private val walletAddressFlow = savedStateHandle.getStateFlow(
        key = "walletAddress",
        initialValue = "tb1qtzrhlwxqcsufs8hvg4c3w33utf9hat4x9xlrf7" // a fix value to check only
    )

    // Updated ViewModel state logic
    val uiState: StateFlow<UiState> =
        getTransactionHistoryUseCase(walletAddressFlow.value)
            .map<AllTransactionHistoryModel, UiState> { transactionsHistory ->
                UiState.Success(transactionsHistory)
            }
            // Handle errors
            .catch { e ->
                emit(UiState.Error(e.message ?: "Unknown error"))
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading
            )
}

// Sealed class representing different UI states
sealed class UiState {
    data object Loading : UiState() // Loading state when data is being fetched
    data class Success(val data: AllTransactionHistoryModel) : UiState() // Success state with transaction history data
    data class Error(val message: String) : UiState() // Error state with an error message
}
