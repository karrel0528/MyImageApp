package me.rell.data

import io.reactivex.Single
import me.rell.data.dto.ImageListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService {

    @GET("photos/")
    fun getImage(
        @Query(CLIENT_ID) key: String = "evythX3W2Wdx4j7WAcTGGyypSsnxxlhLfWkrKVEfdoE"
    ): Single<ImageListDto>

    companion object {
        private const val CLIENT_ID = "client_id"
    }
}