package me.rell.app.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.rell.data.ImageApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ImageApiService = retrofit.create(ImageApiService::class.java)
}