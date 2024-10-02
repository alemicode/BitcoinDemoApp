package com.alemicode.bitcoindemoapp.domain.encryption

import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val listOfWallets: List<String>? = null,
)

@Serializable
data class WalletsAddressModel(
    val walletAddress: String? = null,
)
