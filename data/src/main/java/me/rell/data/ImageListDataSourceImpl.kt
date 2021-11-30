package me.rell.data

import io.reactivex.Single
import me.rell.data.dto.ImageListDto
import timber.log.Timber
import javax.inject.Inject

class ImageListDataSourceImpl @Inject constructor(
    private val api: ImageApiService
) : ImageListDataSource {
    override fun getImageData(page: Int): Single<ImageListDto> {
        Timber.d("ImageListDataSourceImpl > getImageData($page)")
        return api.getImage(page = page)
    }
}