package com.jco.kmp.features.products

import com.jco.kmp.core.presentation.ViewState
import com.jco.kmp.features.ProductItemUIModel

sealed class ProductsViewState: ViewState {
    data class Content(
        val savedProductItems : List<ProductItemUIModel>,
    ) : ProductsViewState()

    object Error : ProductsViewState()
    object Empty : ProductsViewState()
    object Loading : ProductsViewState()
}