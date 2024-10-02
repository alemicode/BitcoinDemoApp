package com.alemicode.bitcoindemoapp.data.networkDatasource


import com.alemicode.bitcoindemoapp.domain.model.response.ConfirmedTransactionDto
import com.alemicode.bitcoindemoapp.domain.model.response.UnconfirmedTransactionDto
import com.alemicode.bitcoindemoapp.domain.model.response.WalletBalanceDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("api/address/{address}/txs")
    suspend fun getConfirmedTransactionHistory(@Path("address") address: String): List<ConfirmedTransactionDto>

    @GET("api/address/{address}/txs/mempool")
    suspend fun getUnconfirmedTransactionHistory(@Path("address") address: String): List<UnconfirmedTransactionDto>

    @GET("api/address/{address}")
    suspend fun getWalletBalance(@Path("address") address: String): WalletBalanceDto
}