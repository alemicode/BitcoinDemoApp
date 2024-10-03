package com.alemicode.bitcoindemoapp.domain.model.model

/**
 * Represents the wallet balance information.
 *
 * @property walletAddress The address of the wallet.
 * @property totalFunded The total amount funded into the wallet.
 * @property totalSpent The total amount spent from the wallet.
 */
data class WalletBalance(
    val walletAddress: String? = null,
    val totalFunded: Int? = 0,
    val totalSpent: Int? = 0
)