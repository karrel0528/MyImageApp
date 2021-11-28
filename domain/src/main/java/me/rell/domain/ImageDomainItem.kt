package me.rell.domain

data class ImageDomainItem(
    val createDate: String,
    val updateDate: String,
    val size: Pair<Int, Int>,
    val color: String,
    val description: String,
    val url: String
)
