package me.rell.domain

import androidx.paging.PagingData
import io.reactivex.Observable

interface ImageRepository {
    fun observePagingImages(): Observable<PagingData<ImageDomainItem>>
}