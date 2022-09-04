package com.estarta.task.data.repository

import com.estarta.task.data.model.ItemResponse
import com.estarta.task.data.network.service.AmazonAwsService
import com.estarta.task.domain.repository.AmazonAwsRepository
import javax.inject.Inject

class AmazonAwsRepositoryImpl @Inject constructor(
    private val awsService: AmazonAwsService
) : AmazonAwsRepository {

    override suspend fun getItems(): List<ItemResponse> = awsService.getDynamodbItems().results
}