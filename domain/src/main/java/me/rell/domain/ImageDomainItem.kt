package me.rell.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageDomainItem(
    val createDate: String,
    val updateDate: String,
    val size: Pair<Int, Int>,
    val color: String,
    val description: String,
    val url: String
) : Parcelable
