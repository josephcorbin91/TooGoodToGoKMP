package com.jco.kmp.core.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel as AndroidXViewModel
import androidx.lifecycle.viewModelScope as androidViewModelScope

actual abstract class BaseViewModel<S: ViewState, A: ViewAction, E: ViewEffect> actual constructor() : AndroidXViewModel() {
    actual val viewModelScope: CoroutineScope = androidViewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }

    actual abstract fun observeSideEffects(): Flow<E>

    actual abstract fun handleIntent(action: A)

    actual abstract fun observeState(): StateFlow<S>
}
