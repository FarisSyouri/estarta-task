package com.estarta.task.di

import com.estarta.task.data.network.client.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkClientsModule {

    @Provides
    @Singleton
    fun provideNetworkClient(retrofitBuilder:  Retrofit.Builder): NetworkClient {
        return NetworkClient(retrofitBuilder)
    }


}