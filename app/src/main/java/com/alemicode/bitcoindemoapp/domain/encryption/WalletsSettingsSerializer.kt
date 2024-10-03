package com.alemicode.bitcoindemoapp.domain.encryption

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

class WalletsSettingsSerializer(
    private val cryptoManager: CryptoManager
) : Serializer<WalletsSettings> {

    override val defaultValue: WalletsSettings
        get() = WalletsSettings()

    override suspend fun readFrom(input: InputStream): WalletsSettings {
        val decryptedBytes = cryptoManager.decrypt(input)
        return try {
            Json.decodeFromString(
                deserializer = WalletsSettings.serializer(),
                string = decryptedBytes.decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: WalletsSettings, output: OutputStream) {
        cryptoManager.encrypt(
            bytes = Json.encodeToString(
                serializer = WalletsSettings.serializer(),
                value = t
            ).encodeToByteArray(),
            outputStream = output
        )
    }
}