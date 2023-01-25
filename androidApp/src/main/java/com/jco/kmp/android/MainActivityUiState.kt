package com.jco.kmp.android

sealed interface MainActivityUiState {
    data class Content(
        val isOnline: Boolean,
    ) : MainActivityUiState

    object Loading : MainActivityUiState
}