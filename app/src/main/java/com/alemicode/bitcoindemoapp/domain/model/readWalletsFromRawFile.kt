package com.alemicode.bitcoindemoapp.domain.model

import android.content.Context
import com.alemicode.bitcoindemoapp.R
import com.alemicode.bitcoindemoapp.domain.encryption.WalletsAddressModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.InputStreamReader

fun readWalletsFromRawFile(context: Context): Flow<List<WalletsAddressModel>> = flow {
    val result = try {
        withContext(Dispatchers.IO) {
            context.resources.openRawResource(R.raw.wallets).use { inputStream ->
                InputStreamReader(inputStream).use { reader ->
                    val walletAddressDtoType = object : TypeToken<List<WalletsAddressModel>>() {}.type
                    Gson().fromJson<List<WalletsAddressModel>>(reader, walletAddressDtoType)
                        ?: emptyList() // Return empty list if parsing fails
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList<WalletsAddressModel>() // Return empty list in case of an error
    }
    emit(result) // Emit the result as a Flow
}