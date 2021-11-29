package me.rell.data

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import me.rell.domain.ImageDomainItem
import timber.log.Timber

class ImageListPagingSource(
    private val imageDataSource: ImageListDataSource
) : RxPagingSource<Int, ImageDomainItem>() {
    override fun getRefreshKey(state: PagingState<Int, ImageDomainItem>): Int? {
        val key = state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
        return key
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ImageDomainItem>> {
        val page = params.key ?: 1

        Timber.d("ImageListPagingSource > page : $page")

        return imageDataSource.getImageData(page = page)
            .map { items -> items.mapToDomainItem() }
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(page, it, params) }
            .onErrorReturn {
                LoadResult.Error(it)
            }
    }

    private fun toLoadResult(
        position: Int,
        items: List<ImageDomainItem>,
        params: LoadParams<Int>
    ): LoadResult<Int, ImageDomainItem> {
        return LoadResult.Page(
            data = items,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (items.isEmpty()) null else position + (params.loadSize / QUERY_PAGE_SIZE)
        )
    }

    companion object {
        const val QUERY_PAGE_SIZE = 10
    }
}