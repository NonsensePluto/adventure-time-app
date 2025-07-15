package com.example.adventuretimes.data.remote.repository

import com.example.adventuretimes.data.remote.CharacterAPI
import com.example.adventuretimes.data.remote.models.CharactersResponse
import javax.inject.Inject

class CharacterDataRepository @Inject constructor(
    private val api: CharacterAPI
){
    suspend fun getAllCharacters() : List<CharactersResponse> {
        return api.getAllCharacters().body() ?: emptyList()
    }
}