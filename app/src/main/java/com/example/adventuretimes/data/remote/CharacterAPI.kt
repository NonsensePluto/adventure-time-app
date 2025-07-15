package com.example.adventuretimes.data.remote

import com.example.adventuretimes.data.remote.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterAPI {
    @GET(Urls.CHARACTERS)
    suspend fun getAllCharacters(): Response<List<CharactersResponse>>
}