package me.rell.app.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rell.data.ImageRepositoryImpl
import me.rell.domain.ImageRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindImageRepository(impl: ImageRepositoryImpl): ImageRepository
}