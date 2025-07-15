package com.example.adventuretimes.data.remote.models

import com.google.gson.annotations.SerializedName

data class CharactersResponse (
    @SerializedName("id")
    val id: Int,

    @SerializedName("displayName")
    val displayName: String,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("fullName")
    val fullName: String,

    @SerializedName("species")
    val race: String,

    @SerializedName("sex")
    val sex: String,

    @SerializedName("quotes")
    val quotes: List<String>,

    @SerializedName("sprites")
    val imageUrl: String?
)
