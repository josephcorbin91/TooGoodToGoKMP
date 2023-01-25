package com.jco.kmp.features.productsearch

import com.jco.kmp.core.presentation.ViewState
import com.jco.kmp.features.ProductItemUIModel

sealed class ProductSearchViewState : ViewState {
    data class Content(
        val searchText: String,
        val productItemUIModel: ProductItemUIModel?,
    ) : ProductSearchViewState()

    object Error : ProductSearchViewState()
    object Loading : ProductSearchViewState()
}