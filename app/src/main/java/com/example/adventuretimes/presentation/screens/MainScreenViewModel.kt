package com.example.adventuretimes.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adventuretimes.domain.repository.CharacterDomainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: CharacterDomainRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(MainScreenState())
    val uiState = _uiState.asStateFlow()

    fun loadCharacters() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        try {
            viewModelScope.launch {
                _uiState.update { state ->
                    state.copy(
                        characters = repository.getAllCharacters(),
                        isLoading = false
                    )
                }
            }
        } catch (ex: Exception) {
            _uiState.value = _uiState.value.copy(errorMessage = "Something went wrong")
        }

    }
}