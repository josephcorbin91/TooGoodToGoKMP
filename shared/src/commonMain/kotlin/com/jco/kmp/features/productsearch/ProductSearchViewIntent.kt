package com.jco.kmp.features.productsearch

import com.jco.kmp.core.presentation.ViewIntent

sealed class ProductSearchViewIntent: ViewIntent {
    object Proceed : ProductSearchViewIntent()
}
