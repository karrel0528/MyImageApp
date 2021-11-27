package me.rell.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ImageModule {

    @Provides
    @Singleton
    fun provideGetImageListUseCase(imageRepository: ImageRepository): GetImageListUseCase =
        GetImageListUseCase(imageRepository)
}