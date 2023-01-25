package com.jco.kmp.android.features.productsearch

import android.annotation.SuppressLint
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jco.kmp.android.designsystem.component.ErrorScreen
import com.jco.kmp.android.designsystem.component.LoadingScreen
import com.jco.kmp.android.features.productsearch.ui.ProductSearchContentScreen
import com.jco.kmp.features.productsearch.ProductSearchViewModelImpl
import com.jco.kmp.features.productsearch.ProductSearchViewState

/**
 * Displays all the contacts.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
@Composable
internal fun ProductSearchScreen(
    productSearchViewState: ProductSearchViewState,
    navController: NavController,
    viewModel: ProductSearchViewModelImpl,
) {
    when (productSearchViewState) {
        ProductSearchViewState.Loading -> LoadingScreen()
        ProductSearchViewState.Error -> ErrorScreen()
        is ProductSearchViewState.Content -> ProductSearchContentScreen(
            productSearchViewState,
            viewModel,
            navController,
        )
    }
}