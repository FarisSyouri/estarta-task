package com.estarta.task.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Item(
    val createdAt: String?,
    val price: String?,
    val name: String?,
    val uid: String?,
    val imageUrl: String?,
    val imageUrlsThumbnails: String?,
): Parcelable
