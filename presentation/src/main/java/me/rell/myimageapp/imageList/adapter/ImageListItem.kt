package me.rell.myimageapp.imageList.adapter

import me.rell.domain.ImageDomainItem

data class ImageListItem(
    val imageUrl: String
) {
    companion object {
        fun mapFromDomainItem(item: ImageDomainItem): ImageListItem {
            return ImageListItem(imageUrl = item.url)
        }
    }
}