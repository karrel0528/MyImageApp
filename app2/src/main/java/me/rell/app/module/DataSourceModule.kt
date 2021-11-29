package me.rell.app.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rell.data.ImageListDataSource
import me.rell.data.ImageListDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindImageDataSource(impl: ImageListDataSourceImpl): ImageListDataSource
}