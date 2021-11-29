package me.rell.data

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import me.rell.domain.ImageDomainItem

class ImageListPagingSource(
    private val imageApiService: ImageApiService
) : RxPagingSource<Int, ImageDomainItem>() {
    override fun getRefreshKey(state: PagingState<Int, ImageDomainItem>): Int? {
        val key = state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
        return key
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ImageDomainItem>> {
        val page = params.key ?: 0

        return imageApiService.getImage(page = page)
            .map { items -> items.convertDomainItem() }
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
            nextKey = nextKey(items, position, params)
        )
    }

    private fun nextKey(
        repos: List<ImageDomainItem>,
        position: Int,
        params: LoadParams<Int>
    ): Int? = if (repos.isEmpty()) {
        null
    } else {
        position + (params.loadSize / QUERY_PAGE_SIZE)
    }

    companion object {
        const val QUERY_PAGE_SIZE = 10
    }
}