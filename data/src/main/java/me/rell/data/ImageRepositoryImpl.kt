package me.rell.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.observable
import io.reactivex.Observable
import me.rell.domain.ImageDomainItem
import me.rell.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageApi: ImageApiService
) : ImageRepository {

    override fun observePagingImages(): Observable<PagingData<ImageDomainItem>> {
        return Pager(
            config = PagingConfig(QUERY_PAGE_SIZE),
            pagingSourceFactory = { ImageListPagingSource(imageApi) }
        ).observable
    }

    companion object {
        private const val QUERY_PAGE_SIZE = 10
    }
}