package com.alemicode.bitcoindemoapp.di

import com.alemicode.bitcoindemoapp.data.networkDatasource.ApiClient
import com.alemicode.bitcoindemoapp.data.repository.TransactionHistoryRepositoryImpl
import com.alemicode.bitcoindemoapp.domain.TransactionHistoryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provides a singleton instance of [Retrofit].
     */
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://blockstream.info/testnet/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Provides a singleton instance of [ApiClient] using the [Retrofit] instance.
     */
    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): ApiClient = retrofit.create(ApiClient::class.java)

    @Provides
    @Singleton
    fun provideTransactionHistoryRepository(
        apiClient: ApiClient
    ): TransactionHistoryRepository {
        return TransactionHistoryRepositoryImpl(apiClient)
    }
}