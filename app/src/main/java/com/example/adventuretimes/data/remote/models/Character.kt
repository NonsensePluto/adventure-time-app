package com.example.adventuretimes.data.remote.models

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id")
    val id: Int,

    @SerializedName("fullName")
    val fullName: String,

    @SerializedName("displayName")
    val displayName: String,

    @SerializedName("species")
    val race: String,

    @SerializedName("sprites")
    val imageUrl: String?
)