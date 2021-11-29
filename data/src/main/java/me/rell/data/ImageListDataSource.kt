package me.rell.data

import io.reactivex.Single
import me.rell.data.dto.ImageListDto

interface ImageListDataSource {
    fun getImageData(page: Int): Single<ImageListDto>
}