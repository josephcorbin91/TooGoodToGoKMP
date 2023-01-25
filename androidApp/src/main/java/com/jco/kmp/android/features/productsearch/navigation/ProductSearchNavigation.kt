package com.jco.kmp.android.features.productsearch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val productSearchRoute = "products_search_route"

fun NavController.navigateToProductSearch(navOptions: NavOptions? = null) {
    this.navigate(productSearchRoute, navOptions)
}

fun NavGraphBuilder.productSearchScreen(navController: NavController) {
    composable(route = productSearchRoute) {
        ProductSearchRoute(navController)
    }
}
