package com.jco.kmp.features.productsearch

import com.jco.kmp.core.presentation.ViewAction

sealed class ProductSearchViewAction: ViewAction {
    data class SearchProductAction(val id: String) : ProductSearchViewAction()
}