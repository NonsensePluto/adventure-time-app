package com.example.adventuretimes.data.di

import com.example.adventuretimes.data.remote.CharacterAPI
import com.example.adventuretimes.data.remote.repository.CharacterDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    const val BASE_URL = "https://adventure-time-api-lg.vercel.app/apiV1/"//возможно надо разделить

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideRepository(apiService: CharacterAPI): CharacterDataRepository {
        return CharacterDataRepository(apiService)
    }
}
