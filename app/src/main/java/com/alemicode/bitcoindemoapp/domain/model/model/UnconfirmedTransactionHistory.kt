package com.alemicode.bitcoindemoapp.domain.model.model

import com.alemicode.bitcoindemoapp.domain.model.response.UnconfirmedStatus

/**
 * Represents an unconfirmed transaction in the transaction history.
 *
 * @property transactionId The unique identifier for the transaction.
 * @property status The status of the unconfirmed transaction.
 * @property amount The amount associated with the transaction.
 */
data class UnconfirmedTransactionHistory(
    val transactionId: String? = null,
    val status: Boolean? = true,
    val amount: Int? = null
)


