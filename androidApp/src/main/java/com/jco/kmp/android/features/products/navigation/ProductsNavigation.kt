package com.jco.kmp.android.features.products.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val productsRoute = "products_route"

fun NavController.navigateToProducts(navOptions: NavOptions? = null) {
    this.navigate(productsRoute, navOptions)
}

fun NavGraphBuilder.productsScreen(navController: NavController) {
    composable(route = productsRoute) {
        ProductsRoute(navController)
    }
}
