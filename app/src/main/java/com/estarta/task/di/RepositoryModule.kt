package com.estarta.task.di

import com.estarta.task.data.network.service.AmazonAwsService
import com.estarta.task.data.repository.AmazonAwsRepositoryImpl
import com.estarta.task.domain.repository.AmazonAwsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(awsService: AmazonAwsService): AmazonAwsRepository {
        return AmazonAwsRepositoryImpl(awsService)
    }

}