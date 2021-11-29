package me.rell.domain

import io.reactivex.Single
import javax.inject.Inject

class GetImageListUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {

    fun get(page: Int = 0): Single<List<ImageDomainItem>> {
        return imageRepository.getImageList(page)
    }
}