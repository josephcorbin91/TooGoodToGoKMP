package com.jco.kmp.core.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

actual abstract class BaseViewModel<S : ViewState, A : ViewAction, E : ViewEffect> actual constructor() {
    actual val viewModelScope: CoroutineScope
        get() = TODO("Not yet implemented")

    protected actual open fun onCleared() {
    }

    actual abstract fun observeState(): StateFlow<S>
    actual abstract fun observeSideEffects(): Flow<E>
    actual abstract fun handleIntent(action: A)

}