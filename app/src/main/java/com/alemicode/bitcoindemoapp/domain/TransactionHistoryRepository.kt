package com.alemicode.bitcoindemoapp.domain
import com.alemicode.bitcoindemoapp.domain.model.model.AllTransactionHistoryModel
import kotlinx.coroutines.flow.Flow

interface TransactionHistoryRepository {
    fun getHistoryTransaction(walletAddress: String = ""): Flow<AllTransactionHistoryModel>
}