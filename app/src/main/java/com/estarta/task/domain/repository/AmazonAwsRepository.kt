package com.estarta.task.domain.repository

import com.estarta.task.data.model.ItemResponse

interface AmazonAwsRepository {

    suspend fun getItems(): List<ItemResponse>

}