package com.example.adventuretimes.presentation.screens

import com.example.adventuretimes.domain.model.CharacterModel

data class MainScreenState (
    val characters: List<CharacterModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)