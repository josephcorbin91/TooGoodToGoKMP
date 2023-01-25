package com.jco.kmp.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jco.kmp.android.util.network.NetworkMonitor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class MainActivityViewModel(
    networkMonitor: NetworkMonitor
) : ViewModel() {

    val mainActivityUiState: StateFlow<MainActivityUiState> = networkMonitor.isOnline
        .map { isOnline -> MainActivityUiState.Content(isOnline) }
        .stateIn(
            scope = viewModelScope,
            initialValue = MainActivityUiState.Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )
}


