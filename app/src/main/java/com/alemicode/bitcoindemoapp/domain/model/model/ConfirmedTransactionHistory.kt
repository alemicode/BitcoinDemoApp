package com.alemicode.bitcoindemoapp.domain.model.model

import com.alemicode.bitcoindemoapp.domain.model.response.ConfirmedStatus

/**
 * Represents a confirmed transaction in the transaction history.
 *
 * @property transactionId The unique identifier for the transaction.
 * @property status The status of the confirmed transaction.
 * @property amount The amount associated with the transaction.
 */
data class ConfirmedTransactionHistory(
    val transactionId: String? = null,
    val status: Boolean? = true,
    val amount: Int? = null
)