package com.estarta.task.data.network.module

import java.io.IOException

sealed class Failure: IOException() {
    object NetworkConnection : Failure()
    object NetworkError : Failure()
    object UnknownError : Failure()
    data class ServerError(override val message: String) : Failure()
}