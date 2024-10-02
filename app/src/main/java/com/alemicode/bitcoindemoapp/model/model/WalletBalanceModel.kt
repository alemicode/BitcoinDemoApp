package com.alemicode.bitcoindemoapp.model.model

/**
 * Represents the wallet balance information.
 *
 * @property walletAddress The address of the wallet.
 * @property totalFunded The total amount funded into the wallet.
 * @property totalSpent The total amount spent from the wallet.
 */
data class WalletBalance(
    val walletAddress: String? = null,
    val totalFunded: Int? = null,
    val totalSpent: Int? = null
)