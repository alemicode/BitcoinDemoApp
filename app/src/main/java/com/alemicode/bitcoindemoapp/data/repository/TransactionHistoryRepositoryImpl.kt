package com.alemicode.bitcoindemoapp.data.repository

import com.alemicode.bitcoindemoapp.data.networkDatasource.ApiClient
import com.alemicode.bitcoindemoapp.domain.TransactionHistoryRepository
import com.alemicode.bitcoindemoapp.domain.model.mapper.toConfirmedTransactionHistory
import com.alemicode.bitcoindemoapp.domain.model.mapper.toUnconfirmedTransactionHistory
import com.alemicode.bitcoindemoapp.domain.model.mapper.toWalletBalance
import com.alemicode.bitcoindemoapp.domain.model.model.AllTransactionHistoryModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Implementation of the [TransactionHistoryRepository] interface.
 * This class fetches transaction history and wallet balance data from the API.
 *
 * @property apiClient The API client to fetch transaction data.
 */
class TransactionHistoryRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : TransactionHistoryRepository {

    override fun getHistoryTransaction(walletAddress: String): Flow<AllTransactionHistoryModel> =
        flow {
            try {
                // Flow to get confirmed transactions
                val confirmedFlow = flow {
                    emit(apiClient.getConfirmedTransactionHistory(walletAddress)
                        .map { it.toConfirmedTransactionHistory() })
                }

                // Flow to get rejected (unconfirmed) transactions
                val rejectedFlow = flow {
                    emit(apiClient.getUnconfirmedTransactionHistory(walletAddress)
                        .map { it.toUnconfirmedTransactionHistory() })
                }

                // Flow to get wallet balance
                val walletBalanceFlow = flow {
                    emit(apiClient.getWalletBalance(walletAddress).toWalletBalance())
                }

                // Combine the flows into a single flow that emits transaction history model
                combine(
                    confirmedFlow,
                    rejectedFlow,
                    walletBalanceFlow
                ) { confirmed, rejected, walletBalance ->
                    AllTransactionHistoryModel(
                        submittedTransactionHistoryModel = confirmed,
                        rejectedTransactionHistoryModel = rejected,
                        walletBalanceModel = walletBalance
                    )
                }.collect { combinedResult ->
                    emit(combinedResult)
                }
            } catch (e: HttpException) {
                throw IOException("Server error: ${e.message()}")
            } catch (e: IOException) {
                throw IOException("Network error: ${e.message}")
            }
        }
}