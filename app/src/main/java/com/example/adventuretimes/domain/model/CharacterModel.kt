package com.example.adventuretimes.domain.model

data class CharacterModel(
    val id: Int,
    val fullName: String,
    val displayName: String,
    val race: String,
    val imageUrl: String?
)