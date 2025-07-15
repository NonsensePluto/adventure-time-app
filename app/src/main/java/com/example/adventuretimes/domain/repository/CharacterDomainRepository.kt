package com.example.adventuretimes.domain.repository

import com.example.adventuretimes.data.remote.repository.CharacterDataRepository
import com.example.adventuretimes.domain.mapper.CharacterResponseToCharacterModel
import com.example.adventuretimes.domain.model.CharacterModel
import javax.inject.Inject

class CharacterDomainRepository @Inject constructor (
    private val characterMapper: CharacterResponseToCharacterModel,
    private val characterDataRepository: CharacterDataRepository
) {
    suspend fun getAllCharacters() : List<CharacterModel> {
        val responseResult = characterDataRepository.getAllCharacters()

        return responseResult.map { character ->
            characterMapper(character)
        }
    }
}