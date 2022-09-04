package com.estarta.task.di

import com.estarta.task.data.network.client.NetworkClient
import com.estarta.task.data.network.service.AmazonAwsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    @Singleton
    fun provideAwsService(networkClient: NetworkClient): AmazonAwsService {
        return networkClient.build().create(AmazonAwsService::class.java)
    }



}