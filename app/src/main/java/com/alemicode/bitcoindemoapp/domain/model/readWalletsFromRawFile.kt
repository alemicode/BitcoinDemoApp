package com.alemicode.bitcoindemoapp.domain.model

import android.content.Context
import com.alemicode.bitcoindemoapp.R
import com.alemicode.bitcoindemoapp.domain.encryption.WalletsAddressModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

fun readWalletsFromRawFile(context: Context): List<WalletsAddressModel> {
    return try {
        context.resources.openRawResource(R.raw.wallets).use { inputStream ->
            InputStreamReader(inputStream).use { reader ->
                val walletAddressDtoType = object : TypeToken<List<WalletsAddressModel>>() {}.type
                Gson().fromJson(reader, walletAddressDtoType)
                    ?: emptyList() // Return an empty list if parsing fails
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList() // Return an empty list in case of an error
    }
}