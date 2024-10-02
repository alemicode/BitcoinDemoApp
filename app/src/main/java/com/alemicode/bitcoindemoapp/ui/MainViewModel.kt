package com.alemicode.bitcoindemoapp.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alemicode.bitcoindemoapp.domain.GetTransactionHistoryUseCase
import com.alemicode.bitcoindemoapp.domain.model.model.AllTransactionHistoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTransactionHistoryUseCase: GetTransactionHistoryUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val walletAddressFlow = savedStateHandle.getStateFlow(
        key = "walletAddress",
        initialValue = "tb1qtzrhlwxqcsufs8hvg4c3w33utf9hat4x9xlrf7" // A temp wallet address
    )

    // MutableStateFlow to trigger refresh
    private val _refreshTrigger = MutableStateFlow(false)
    val refreshTrigger: StateFlow<Boolean> = _refreshTrigger.asStateFlow()

    // Combined flow to handle the state updates
    val walletInformationUiState: StateFlow<WalletInformationUiState> =
        combine(walletAddressFlow, _refreshTrigger) { address, _ ->
            address // Just pass through the address; refresh trigger is ignored in this context

        }.flatMapLatest { address ->
            getTransactionHistoryUseCase(address)
                .map<AllTransactionHistoryModel, WalletInformationUiState> { transactionsHistory ->
                    WalletInformationUiState.Success(transactionsHistory)
                }
                .catch { e ->
                    emit(WalletInformationUiState.Error(e.message ?: "Unknown error"))
                }
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = WalletInformationUiState.Loading
            )

    // Method to trigger refresh
    fun refreshData() {
        _refreshTrigger.value != _refreshTrigger.value // Increment counter to force state change
    }
}

// Sealed class representing different UI states
sealed class WalletInformationUiState {
    data object Loading : WalletInformationUiState()
    data class Success(val data: AllTransactionHistoryModel) : WalletInformationUiState()
    data class Error(val message: String) : WalletInformationUiState()
}
