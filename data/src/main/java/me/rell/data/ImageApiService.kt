package me.rell.data

import io.reactivex.Single
import me.rell.data.dto.ImageListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService {

    @GET("photos/")
    fun getImage(
        @Query(QUERY_CLIENT_ID) key: String = "evythX3W2Wdx4j7WAcTGGyypSsnxxlhLfWkrKVEfdoE",
        @Query(QUERY_PAGE) page: Int = 0
    ): Single<ImageListDto>

    companion object {
        private const val QUERY_CLIENT_ID = "client_id"
        private const val QUERY_PAGE = "page"
    }
}