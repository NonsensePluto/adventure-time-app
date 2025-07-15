package com.example.adventuretimes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.loader.content.Loader
import com.example.adventuretimes.presentation.screens.Character
import com.example.adventuretimes.presentation.screens.MainScreenViewModel
import com.example.adventuretimes.ui.theme.AdventureTimesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdventureTimesTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                MainScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    // Получаем ViewModel через Hilt
    val mainViewModel: MainScreenViewModel = viewModel()

    // Собираем состояние с учетом жизненного цикла
    val state by mainViewModel.uiState.collectAsStateWithLifecycle()

    // Загружаем персонажей при первом запуске
    LaunchedEffect(Unit) {
        mainViewModel.loadCharacters()
    }

    Scaffold (
        topBar = {
            TopAppBar(title = {Text("Персонажи")})
        }
    ) {
        paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator()
                }

                state.errorMessage != null -> {
                    Text(text = state.errorMessage!!)
                }

                else -> {
                    LazyColumn (
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp),
                    ){
                        items(state.characters) { character ->
                            Character(
                                modifier = Modifier.fillMaxSize(),
                                character = character
                            )
                        }
                    }
                }
            }
        }
    }
}