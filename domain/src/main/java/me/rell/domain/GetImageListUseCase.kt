package me.rell.domain

import io.reactivex.Single
import javax.inject.Inject

class GetImageListUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {
    fun get(): Single<List<ImageItem>> {

        // fixme test code
        return Single.just(listOf(createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
            createTestImageItem(),
        ))
//        return imageRepository.getImageList()
    }

    fun createTestImageItem(): ImageItem {
        return ImageItem(
            createDate = "",
            updateDate = "",
            color = "",
            size = Pair(123,123),
            title = "test title",
            url = "https://images.unsplash.com/photo-1633114129669-78b1ff09902b?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyNzg0NzV8MXwxfGFsbHwxfHx8fHx8Mnx8MTYzODAwMDY0Mg&ixlib=rb-1.2.1&q=80&w=400"
        )
    }
}