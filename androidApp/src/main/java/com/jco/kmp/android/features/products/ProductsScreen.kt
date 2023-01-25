package com.jco.kmp.android.features.products

import android.annotation.SuppressLint
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jco.kmp.android.designsystem.component.ErrorScreen
import com.jco.kmp.android.designsystem.component.LoadingScreen
import com.jco.kmp.features.products.ProductsViewState
import com.jco.kmp.android.features.products.ui.SavedProductsScreen

/**
 * Displays all the contacts.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
@Composable
internal fun ProductsScreen(
    productsViewState: ProductsViewState,
    navController: NavController,
) {
    when (productsViewState) {
        ProductsViewState.Loading -> LoadingScreen()
        ProductsViewState.Error -> ErrorScreen()
        ProductsViewState.Empty -> ErrorScreen()
        is ProductsViewState.Content -> SavedProductsScreen(
            productsViewState,
            navController,
        )
    }
}