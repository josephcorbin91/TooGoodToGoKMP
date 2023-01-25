package com.jco.kmp.android.features.products.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.jco.kmp.android.designsystem.component.ProductListItem
import com.jco.kmp.features.products.ProductsViewState

@Composable
fun SavedProductsScreen(
    productsViewState: ProductsViewState.Content,
    navController: NavController
) {

    LazyColumn {
        items(items = productsViewState.savedProductItems, key = { it.id }) { productItem ->
            ProductListItem(
                product = productItem, onNavigateToProductDetail =
                {
                    val navOptions = navOptions {
                        launchSingleTop = true
                    }
                    navController.navigate(
                        "product_details_route/productId=${productItem.id}",
                        navOptions
                    )
                })
        }
    }
}
