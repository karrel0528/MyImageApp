package me.rell.domain

import javax.inject.Inject

class GetImageListUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {
    fun get() = imageRepository.getImageList()
}