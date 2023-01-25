package com.jco.kmp.core.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

expect abstract class BaseViewModel<S: ViewState, A: ViewAction, E: ViewEffect>() {

    val viewModelScope: CoroutineScope
    protected open fun onCleared()
    abstract fun observeState() : StateFlow<S>
    abstract fun observeSideEffects(): Flow<E>
    abstract fun handleIntent(action: A)
}