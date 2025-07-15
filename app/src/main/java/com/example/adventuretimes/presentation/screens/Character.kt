package com.example.adventuretimes.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.example.adventuretimes.domain.model.CharacterModel

@Composable
fun Character(
    modifier: Modifier,
    character: CharacterModel
) {
    Card (
//        modifier = modifier.fillMaxWidth(),
        colors = CardColors(Color.White, Color.Black, Color.Gray, Color.Gray)
    ) {
        Row {
            AsyncImage(
                model = character.imageUrl,
                contentDescription = "Character Image",
                modifier = modifier.fillMaxSize(),
                clipToBounds = true,
            )
            Column {

                Text(
                    text = character.displayName,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = character.fullName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray
                )
            }
        }
    }
}