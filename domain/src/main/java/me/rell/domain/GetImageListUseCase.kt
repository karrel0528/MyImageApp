package me.rell.domain

import io.reactivex.Single
import javax.inject.Inject

class GetImageListUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {
    fun get(): Single<List<ImageItem>> {
        return imageRepository.getImageList()
    }
}