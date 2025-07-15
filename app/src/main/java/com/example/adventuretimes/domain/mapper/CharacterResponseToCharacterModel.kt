package com.example.adventuretimes.domain.mapper

import com.example.adventuretimes.data.remote.models.CharactersResponse
import com.example.adventuretimes.domain.model.CharacterModel
import javax.inject.Inject

class CharacterResponseToCharacterModel @Inject constructor() {
    operator fun invoke(charactersResponse: CharactersResponse): CharacterModel {
        return CharacterModel(
            charactersResponse.id,
            charactersResponse.fullName,
            charactersResponse.displayName,
            charactersResponse.race,
            charactersResponse.imageUrl
        )
    }
}