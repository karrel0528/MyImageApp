package me.rell.domain

import io.reactivex.Single

interface ImageRepository {
    fun getImageList(): Single<List<ImageItem>>
}