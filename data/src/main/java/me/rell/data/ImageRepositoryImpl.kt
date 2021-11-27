package me.rell.data

import io.reactivex.Single
import me.rell.domain.ImageItem
import me.rell.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor() : ImageRepository {
    override fun getImageList(): Single<List<ImageItem>> {
        // fixme test code
        return Single.just(emptyList())
    }
}