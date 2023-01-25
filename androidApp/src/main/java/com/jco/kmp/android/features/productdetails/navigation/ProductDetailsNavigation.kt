package com.jco.kmp.android.features.productdetails.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val PRODUCT_ID =  "productId"
const val productDetailsRouteBase = "product_details_route/$PRODUCT_ID="
const val productDetailsRoute = "product_details_route/$PRODUCT_ID={productId}"

fun NavGraphBuilder.productDetailsScreen() {
    composable(
        route = productDetailsRoute,
        arguments = listOf(
            navArgument(PRODUCT_ID) {
                type = NavType.StringType
            }
        )
    ) {
        ProductDetailsRoute()
    }
}
