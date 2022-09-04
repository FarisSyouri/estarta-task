package com.estarta.task.data.network.service

import com.estarta.task.data.model.FullItemsResponse
import retrofit2.http.GET


interface AmazonAwsService {

    @GET("default/dynamodb-writer")
    suspend fun getDynamodbItems(): FullItemsResponse


}