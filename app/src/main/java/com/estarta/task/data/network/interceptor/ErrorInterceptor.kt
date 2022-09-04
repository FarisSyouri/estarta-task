package com.estarta.task.data.network.interceptor

import com.estarta.task.data.network.module.Failure
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject

class ErrorInterceptor : Interceptor {

    @Throws(Failure::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        try {
            val response = chain.proceed(request)

            if (!response.isSuccessful) {
                return readErrorObject(response)
            }
            return response
        } catch (e: Exception) {
            if (e is Failure.ServerError)
                throw  e
            else
                throw Failure.NetworkError
        }
    }

    @Throws(Failure::class)
    private fun readErrorObject(response: Response): Response {
        response.peekBody(2048).string().let {
            try {
                val jsonObject = JSONObject(it)
                throw Failure.ServerError(jsonObject.getString("Message"))
            } catch (e: JSONException) {
                throw Failure.NetworkError
            }
        }
    }
}
