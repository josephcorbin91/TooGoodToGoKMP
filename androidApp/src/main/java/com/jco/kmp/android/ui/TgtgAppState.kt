package com.jco.kmp.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.jco.kmp.android.MainActivityUiState
import com.jco.kmp.android.navigation.BottomBarDestination
import com.jco.kmp.android.features.productdetails.navigation.productDetailsRoute
import com.jco.kmp.android.features.products.navigation.navigateToProducts
import com.jco.kmp.android.features.products.navigation.productsRoute
import com.jco.kmp.android.features.productsearch.navigation.navigateToProductSearch
import com.jco.kmp.android.navigation.CurrentDestinationState
import com.jco.tgtg.navigation.FabState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberTgtgAppState(
    mainActivityUiState: StateFlow<MainActivityUiState>,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): TgtgAppState {
    return remember(navController, coroutineScope, mainActivityUiState) {
        TgtgAppState(navController, coroutineScope, mainActivityUiState)
    }
}

@Stable
class TgtgAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    val mainActivityUiState: StateFlow<MainActivityUiState>
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    val currentDestinationState: CurrentDestinationState
        @Composable get() = when (currentDestination?.route) {
            productsRoute -> CurrentDestinationState.PRODUCTS_TOP_BAR_STATE
            productDetailsRoute -> CurrentDestinationState.PRODUCT_DETAILS_TOP_BAR_STATE
            else -> CurrentDestinationState.PRODUCTS_SEARCH_TOP_BAR_STATE
        }

    val currentFabState: FabState
        @Composable get() = when (currentDestination?.route) {
            productsRoute -> FabState.PRODUCTS_TOP_BAR_STATE
            productDetailsRoute -> FabState.PRODUCT_DETAILS_TOP_BAR_STATE
            else -> FabState.PRODUCT_SEARCH_TOP_BAR_STATE

        }

    val shouldShowBottomBar: Boolean
        @Composable get() = currentDestination?.route?.contains(productDetailsRoute)?.not()
            ?: true

    val isOffline = mainActivityUiState.map {
        if (it is MainActivityUiState.Content) it.isOnline.not() else false
    }.stateIn(
        scope = coroutineScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )

    val bottomBarDestinations: List<BottomBarDestination> = BottomBarDestination.values().asList()

    fun navigateToBottomBarDestination(bottomBarDestination: BottomBarDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
            restoreState = true
        }

        when (bottomBarDestination) {
            BottomBarDestination.SEARCH_PRODUCTS -> navController.navigateToProductSearch(
                topLevelNavOptions
            )
            BottomBarDestination.SAVED_PRODUCTS -> navController.navigateToProducts(
                topLevelNavOptions
            )
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}