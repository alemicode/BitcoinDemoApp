package com.alemicode.bitcoindemoapp.model.response

import com.google.gson.annotations.SerializedName

/**
 * Represents an unconfirmed transaction data transfer object (DTO).
 *
 * @property locktime The lock time of the transaction.
 * @property size The size of the transaction.
 * @property fee The transaction fee.
 * @property txid The unique identifier for the transaction.
 * @property weight The weight of the transaction.
 * @property vin The list of input transaction items.
 * @property version The version of the transaction.
 * @property vout The list of output transaction items.
 * @property status The status of the unconfirmed transaction.
 */
data class UnconfirmedTransactionDto(

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
    val vin: List<UnconfirmedVinItem?>? = null,

    @field:SerializedName("version")
    val version: Int? = null,

    @field:SerializedName("vout")
    val vout: List<UnconfirmedVoutItem?>? = null,

    @field:SerializedName("status")
    val status: UnconfirmedStatus? = null
)

/**
 * Represents the previous output data of an unconfirmed transaction.
 *
 * @property scriptpubkeyAddress The address from the script public key.
 * @property scriptpubkey The script public key.
 * @property scriptpubkeyAsm The assembly representation of the script public key.
 * @property scriptpubkeyType The type of the script public key.
 * @property value The value associated with the previous output.
 */
data class UnconfirmedPrevout(

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
 * Represents the status of an unconfirmed transaction.
 *
 * @property confirmed Indicates whether the transaction is confirmed.
 */
data class UnconfirmedStatus(

    @field:SerializedName("confirmed")
    val confirmed: Boolean? = null
)

/**
 * Represents an input item in an unconfirmed transaction.
 *
 * @property scriptsig The script signature of the input.
 * @property witness The witness data associated with the input.
 * @property sequence The sequence number of the input.
 * @property scriptsigAsm The assembly representation of the script signature.
 * @property prevout The previous output associated with this input.
 * @property isCoinbase Indicates if this input is a coinbase transaction.
 * @property txid The unique identifier for the transaction.
 * @property vout The index of the output this input is spending.
 */
data class UnconfirmedVinItem(

    @field:SerializedName("scriptsig")
    val scriptsig: String? = null,

    @field:SerializedName("witness")
    val witness: List<String?>? = null,

    @field:SerializedName("sequence")
    val sequence: Long? = null,

    @field:SerializedName("scriptsig_asm")
    val scriptsigAsm: String? = null,

    @field:SerializedName("prevout")
    val prevout: UnconfirmedPrevout? = null,

    @field:SerializedName("is_coinbase")
    val isCoinbase: Boolean? = null,

    @field:SerializedName("txid")
    val txid: String? = null,

    @field:SerializedName("vout")
    val vout: Int? = null
)

/**
 * Represents an output item in an unconfirmed transaction.
 *
 * @property scriptpubkeyAddress The address from the script public key.
 * @property scriptpubkey The script public key.
 * @property scriptpubkeyAsm The assembly representation of the script public key.
 * @property scriptpubkeyType The type of the script public key.
 * @property value The value associated with the output.
 */
data class UnconfirmedVoutItem(

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
