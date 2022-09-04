package com.estarta.task.data.network.client

import com.estarta.task.BuildConfig
import retrofit2.Retrofit

class NetworkClient(private val retrofitBuilder: Retrofit.Builder){

      private val baseUrl: String = BuildConfig.BASE_URL

    fun build(): Retrofit {
        return retrofitBuilder.baseUrl(baseUrl).build()
    }
}