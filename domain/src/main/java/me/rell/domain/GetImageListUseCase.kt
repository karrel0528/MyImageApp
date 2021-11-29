package me.rell.domain

import androidx.paging.PagingData
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetImageListUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {

    operator fun invoke(): Observable<PagingData<ImageDomainItem>> {
        return imageRepository.observePagingImages()
    }
}