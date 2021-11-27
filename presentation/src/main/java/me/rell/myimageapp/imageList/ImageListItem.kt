package me.rell.myimageapp.imageList

import me.rell.domain.ImageItem

data class ImageListItem(
    val imageUrl: String
) {
    companion object {
        fun mapFromDomainItem(item: ImageItem): ImageListItem {
            return ImageListItem(imageUrl = item.url)
        }
    }
}