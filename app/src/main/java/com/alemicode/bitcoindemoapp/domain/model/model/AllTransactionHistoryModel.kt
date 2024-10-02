package com.alemicode.bitcoindemoapp.domain.model.model


data class AllTransactionHistoryModel(
    val submittedTransactionHistoryModel: List<ConfirmedTransactionHistory>,
    val rejectedTransactionHistoryModel: List<UnconfirmedTransactionHistory>,
    val walletBalanceModel: WalletBalance,
)