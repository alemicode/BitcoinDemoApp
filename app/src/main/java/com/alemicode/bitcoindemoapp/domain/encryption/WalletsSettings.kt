package com.alemicode.bitcoindemoapp.domain.encryption

import kotlinx.serialization.Serializable

@Serializable
data class WalletsSettings(
    val listOfWallets: List<String>? = null,
)

@Serializable
data class WalletsAddressModel(
    val walletAddress: String? = null,
)
