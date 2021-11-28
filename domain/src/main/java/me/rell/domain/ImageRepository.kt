package me.rell.domain

import io.reactivex.Single

interface ImageRepository {
    fun getImageList(page: Int): Single<List<ImageItem>>
}