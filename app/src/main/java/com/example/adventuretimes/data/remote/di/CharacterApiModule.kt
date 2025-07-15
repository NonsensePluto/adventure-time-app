package com.example.adventuretimes.data.remote.di

import com.example.adventuretimes.data.remote.CharacterAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterApiModule {

    @Singleton
    @Provides
    fun providesCharacterApi(retrofit: Retrofit) =
        retrofit.create(CharacterAPI::class.java)
}