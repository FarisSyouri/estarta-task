package com.estarta.task.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemResponse(
    @Json(name = "created_at") var createdAt: String?,
    @Json(name = "price") val price: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "uid") val uid: String?,
    @Json(name = "image_urls") val imageUrl: List<String>?,
    @Json(name = "image_urls_thumbnails") val imageUrlsThumbnails: List<String>?,
): Parcelable
