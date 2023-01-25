package com.jco.tgtg.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jco.kmp.android.features.productdetails.navigation.productDetailsScreen
import com.jco.kmp.android.features.products.navigation.productsScreen
import com.jco.kmp.android.features.productsearch.navigation.productSearchRoute
import com.jco.kmp.android.features.productsearch.navigation.productSearchScreen

@Composable
fun TgtgNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = productSearchRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        productSearchScreen(navController)
        productDetailsScreen()
        productsScreen(navController)
    }
}
