package com.alemicode.bitcoindemoapp.domain

import com.alemicode.bitcoindemoapp.domain.model.model.AllTransactionHistoryModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionHistoryUseCase @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository
) {
    operator fun invoke(walletAddress: String): Flow<AllTransactionHistoryModel> =
        transactionHistoryRepository.getHistoryTransaction(walletAddress)
}