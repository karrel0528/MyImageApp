package me.rell.domain

data class ImageItem(
    val createDate: String,
    val updateDate: String,
    val size: Pair<Int, Int>,
    val color: String,
    val title: String,
    val url: String
)
