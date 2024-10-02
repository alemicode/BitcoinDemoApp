package com.alemicode.bitcoindemoapp.model.response

import com.google.gson.annotations.SerializedName

/**
 * Represents a confirmed transaction data transfer object (DTO).
 *
 * @property locktime The lock time of the transaction.
 * @property size The size of the transaction.
 * @property fee The transaction fee.
 * @property txid The unique identifier for the transaction.
 * @property weight The weight of the transaction.
 * @property vin The list of input transaction items.
 * @property version The version of the transaction.
 * @property vout The list of output transaction items.
 * @property submittedStatus The status of the confirmed transaction.
 */
data class ConfirmedTransactionDto(

	@field:SerializedName("locktime")
	val locktime: Int? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("fee")
	val fee: Int? = null,

	@field:SerializedName("txid")
	val txid: String? = null,

	@field:SerializedName("weight")
	val weight: Int? = null,

	@field:SerializedName("vin")
	val vin: List<ConfirmedVinItem?>? = null,

	@field:SerializedName("version")
	val version: Int? = null,

	@field:SerializedName("vout")
	val vout: List<ConfirmedVoutItem?>? = null,

	@field:SerializedName("status")
	val confirmedStatus: ConfirmedStatus? = null
)

/**
 * Represents an input item in a confirmed transaction.
 *
 * @property scriptsig The script signature of the input.
 * @property witness The witness data associated with the input.
 * @property sequence The sequence number of the input.
 * @property innerRedeemscriptAsm The assembly representation of the inner redeem script.
 * @property scriptsigAsm The assembly representation of the script signature.
 * @property submittedPrevout The previous output associated with this input.
 * @property isCoinbase Indicates if this input is a coinbase transaction.
 * @property txid The unique identifier for the transaction.
 * @property vout The index of the output this input is spending.
 */
data class ConfirmedVinItem(

	@field:SerializedName("scriptsig")
	val scriptsig: String? = null,

	@field:SerializedName("witness")
	val witness: List<String?>? = null,

	@field:SerializedName("sequence")
	val sequence: Long? = null,

	@field:SerializedName("inner_redeemscript_asm")
	val innerRedeemscriptAsm: String? = null,

	@field:SerializedName("scriptsig_asm")
	val scriptsigAsm: String? = null,

	@field:SerializedName("prevout")
	val confirmedPrevout: ConfirmedPrevout? = null,

	@field:SerializedName("is_coinbase")
	val isCoinbase: Boolean? = null,

	@field:SerializedName("txid")
	val txid: String? = null,

	@field:SerializedName("vout")
	val vout: Int? = null
)

/**
 * Represents the status of a confirmed transaction.
 *
 * @property blockTime The time the block was mined.
 * @property blockHash The hash of the block containing the transaction.
 * @property blockHeight The height of the block in the blockchain.
 * @property confirmed Indicates whether the transaction is confirmed.
 */
data class ConfirmedStatus(

	@field:SerializedName("block_time")
	val blockTime: Int? = null,

	@field:SerializedName("block_hash")
	val blockHash: String? = null,

	@field:SerializedName("block_height")
	val blockHeight: Int? = null,

	@field:SerializedName("confirmed")
	val confirmed: Boolean? = null
)

/**
 * Represents an output item in a confirmed transaction.
 *
 * @property scriptpubkeyAddress The address from the script public key.
 * @property scriptpubkey The script public key.
 * @property scriptpubkeyAsm The assembly representation of the script public key.
 * @property scriptpubkeyType The type of the script public key.
 * @property value The amount of cryptocurrency (e.g., Bitcoin) being transferred to the recipient in this output.
 */
data class ConfirmedVoutItem(

	@field:SerializedName("scriptpubkey_address")
	val scriptpubkeyAddress: String? = null,

	@field:SerializedName("scriptpubkey")
	val scriptpubkey: String? = null,

	@field:SerializedName("scriptpubkey_asm")
	val scriptpubkeyAsm: String? = null,

	@field:SerializedName("scriptpubkey_type")
	val scriptpubkeyType: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
)

/**
 * Represents the previous output data of a confirmed transaction.
 *
 * @property scriptpubkeyAddress The address from the script public key.
 * @property scriptpubkey The script public key.
 * @property scriptpubkeyAsm The assembly representation of the script public key.
 * @property scriptpubkeyType The type of the script public key.
 * @property value The value associated with the previous output.
 */
data class ConfirmedPrevout(

	@field:SerializedName("scriptpubkey_address")
	val scriptpubkeyAddress: String? = null,

	@field:SerializedName("scriptpubkey")
	val scriptpubkey: String? = null,

	@field:SerializedName("scriptpubkey_asm")
	val scriptpubkeyAsm: String? = null,

	@field:SerializedName("scriptpubkey_type")
	val scriptpubkeyType: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
)
