package com.alemicode.bitcoindemoapp.model.response

import com.google.gson.annotations.SerializedName

data class WalletBalanceDto(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("chain_stats")
	val chainStats: ChainStats? = null,

	@field:SerializedName("mempool_stats")
	val mempoolStats: MempoolStats? = null
)

data class ChainStats(

	@field:SerializedName("spent_txo_count")
	val spentTxoCount: Int? = null,

	@field:SerializedName("tx_count")
	val txCount: Int? = null,

	@field:SerializedName("funded_txo_count")
	val fundedTxoCount: Int? = null,

	@field:SerializedName("spent_txo_sum")
	val spentTxoSum: Int? = null,

	@field:SerializedName("funded_txo_sum")
	val fundedTxoSum: Int? = null
)

data class MempoolStats(

	@field:SerializedName("spent_txo_count")
	val spentTxoCount: Int? = null,

	@field:SerializedName("tx_count")
	val txCount: Int? = null,

	@field:SerializedName("funded_txo_count")
	val fundedTxoCount: Int? = null,

	@field:SerializedName("spent_txo_sum")
	val spentTxoSum: Int? = null,

	@field:SerializedName("funded_txo_sum")
	val fundedTxoSum: Int? = null
)
