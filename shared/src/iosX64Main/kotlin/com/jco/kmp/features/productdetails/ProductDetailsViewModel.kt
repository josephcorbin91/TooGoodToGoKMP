package com.jco.kmp.features.productdetails

import com.jco.kmp.core.presentation.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

actual class ProductDetailsViewModel actual constructor() :
    BaseViewModel<ProductDetailsViewState, ProductDetailsViewAction, ProductDetailsViewEffect>() {
    override fun observeState(): StateFlow<ProductDetailsViewState> {
        TODO("Not yet implemented")
    }

    override fun observeSideEffects(): Flow<ProductDetailsViewEffect> {
        TODO("Not yet implemented")
    }

    override fun handleIntent(action: ProductDetailsViewAction) {
        TODO("Not yet implemented")
    }
}