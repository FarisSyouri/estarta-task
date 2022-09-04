package com.estarta.task.data.model

import com.squareup.moshi.Json

data class FullItemsResponse(

    @Json(name = "results") var results : List<ItemResponse>

)
