package com.jco.kmp.android.features.productsearch.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.jco.kmp.android.R
import com.jco.kmp.android.designsystem.component.ProductListItem
import com.jco.kmp.features.productsearch.ProductSearchViewAction
import com.jco.kmp.features.productsearch.ProductSearchViewModelImpl
import com.jco.kmp.features.productsearch.ProductSearchViewModelImpl.Companion.MINIMUM_PRODUCT_LENGTH
import com.jco.kmp.features.productsearch.ProductSearchViewState

@Composable
fun ProductSearchContentScreen(
    productScreenUiState: ProductSearchViewState.Content,
    productSearchViewModelImpl: ProductSearchViewModelImpl,
    navController: NavController
) {
    Column {
        ProductSearchBar(
            modifier = Modifier.fillMaxWidth(), productScreenUiState, productSearchViewModelImpl
        )

        productScreenUiState.productItemUIModel?.let {
            ProductListItem(it, onNavigateToProductDetail =
            {
                val navOptions = navOptions {
                    launchSingleTop = true
                }
                navController.navigate(
                    "product_details_route/productId=${it.id}",
                    navOptions
                )
            })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductSearchBar(
    modifier: Modifier = Modifier,
    productScreenUiState: ProductSearchViewState.Content,
    viewModel: ProductSearchViewModelImpl
) {
    val textSearch = productScreenUiState.searchText
    Row(
        modifier = modifier
            .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            .background(MaterialTheme.colorScheme.surface, CircleShape)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = R.string.search),
            modifier = Modifier.padding(start = 16.dp),
            tint = MaterialTheme.colorScheme.outline
        )
        TextField(value = textSearch,
            onValueChange = { value ->
                if (value.length <= MINIMUM_PRODUCT_LENGTH) {
                    viewModel.handleIntent(ProductSearchViewAction.SearchProductAction(value))
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            label = {
                Text(
                    stringResource(id = R.string.search_content_description),
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium,
                )
            })
    }
}