package me.rell.app.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import me.rell.domain.GetImageListUseCase
import me.rell.domain.ImageRepository
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
object ImageDomainModule {

    @Provides
    @ViewModelScoped
    fun provideGetImageListUseCase(imageRepository: ImageRepository): GetImageListUseCase =
        GetImageListUseCase(imageRepository)
}