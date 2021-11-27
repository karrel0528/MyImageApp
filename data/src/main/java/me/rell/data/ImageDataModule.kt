package me.rell.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rell.domain.ImageRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class ImageDataModule {

    @Singleton
    @Binds
    abstract fun bindImageRepository(impl:ImageRepositoryImpl): ImageRepository
}