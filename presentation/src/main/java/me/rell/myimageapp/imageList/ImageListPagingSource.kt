package me.rell.myimageapp.imageList

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import me.rell.domain.GetImageListUseCase
import me.rell.myimageapp.imageList.adapter.ImageListItem

class ImageListPagingSource(
    private val getImageListUseCase: GetImageListUseCase
) : RxPagingSource<Int, ImageListItem>() {
    override fun getRefreshKey(state: PagingState<Int, ImageListItem>): Int? {
        val key = state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
        return key
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ImageListItem>> {
        val page = params.key ?: 0

        return getImageListUseCase(page)
            .map { items -> items.map(ImageListItem::mapFromDomainItem) }
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(page, it, params) }
            .onErrorReturn {
                LoadResult.Error(it)
            }
    }

    private fun toLoadResult(
        position: Int,
        items: List<ImageListItem>,
        params: LoadParams<Int>
    ): LoadResult<Int, ImageListItem> {
        return LoadResult.Page(
            data = items,
            prevKey = if (position == 1) null else position - 1,
            nextKey = nextKey(items, position, params)
        )
    }

    private fun nextKey(
        repos: List<ImageListItem>,
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