package com.alemicode.bitcoindemoapp.domain.model.mapper

import com.alemicode.bitcoindemoapp.domain.model.model.ConfirmedTransactionHistory
import com.alemicode.bitcoindemoapp.domain.model.model.UnconfirmedTransactionHistory
import com.alemicode.bitcoindemoapp.domain.model.model.WalletBalance
import com.alemicode.bitcoindemoapp.domain.model.response.ConfirmedTransactionDto
import com.alemicode.bitcoindemoapp.domain.model.response.UnconfirmedTransactionDto
import com.alemicode.bitcoindemoapp.domain.model.response.WalletBalanceDto

// Extension functions for converting DTOs to models

/**
 * Converts a ConfirmedTransactionDto to a ConfirmedTransactionHistory model.
 */
fun ConfirmedTransactionDto.toConfirmedTransactionHistory() = ConfirmedTransactionHistory(
    transactionId = this.txid,
    status = this.confirmedStatus,
    amount = this.vout?.get(0)?.value
)

/**
 * Converts an UnconfirmedTransactionDto to an UnconfirmedTransactionHistory model.
 */
fun UnconfirmedTransactionDto.toUnconfirmedTransactionHistory() = UnconfirmedTransactionHistory(
    transactionId = this.txid,
    status = this.status,
    amount = this.vout?.get(0)?.value
)

/**
 * Converts a WalletBalanceDto to a WalletBalance model.
 */
fun WalletBalanceDto.toWalletBalance() = WalletBalance(
    walletAddress = this.address,
    totalFunded = this.chainStats?.fundedTxoSum,
    totalSpent = this.chainStats?.spentTxoSum
)