package com.jco.kmp.features.productdetails

import com.jco.kmp.core.domain.product.uimodel.ProductDetailUIModel
import com.jco.kmp.core.presentation.ViewState

sealed class ProductDetailsViewState : ViewState {
    data class Content(
        val productDetailUIModel: ProductDetailUIModel
    ) : ProductDetailsViewState()

    object Error : ProductDetailsViewState()
    object Loading : ProductDetailsViewState()
}