package me.rell.data.dto

import me.rell.domain.ImageDomainItem

class ImageListDto : ArrayList<ImageListDtoItem>() {

    fun convertDomainItem(): List<ImageDomainItem> {
        val items = arrayListOf<ImageDomainItem>()

        this.forEach { dtoItem ->
            ImageDomainItem(
                createDate = dtoItem.created_at ?: "",
                updateDate = dtoItem.updated_at ?: "",
                size = Pair(dtoItem.width ?: -1, dtoItem.height ?: -1),
                color = dtoItem.color ?: "#FFF",
                description = dtoItem.description ?: "",
                url = dtoItem.urls?.small ?: ""
            ).also(items::add)
        }

        return items
    }
}