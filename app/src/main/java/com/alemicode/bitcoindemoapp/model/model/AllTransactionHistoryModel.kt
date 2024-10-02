package com.alemicode.bitcoindemoapp.model.model


data class AllTransactionHistoryModel(
    val submittedTransactionHistoryModel: List<ConfirmedTransactionHistory>,
    val rejectedTransactionHistoryModel: List<UnconfirmedTransactionHistory>,
    val walletBalanceModel: WalletBalance,
)