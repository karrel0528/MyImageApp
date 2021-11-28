package me.rell.data

import io.reactivex.Single
import me.rell.domain.ImageItem
import me.rell.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageApi: ImageApiService
) : ImageRepository {
    override fun getImageList(page: Int): Single<List<ImageItem>> {
        return imageApi.getImage(page = page).map { it.convertDomainItem() }
    }
}