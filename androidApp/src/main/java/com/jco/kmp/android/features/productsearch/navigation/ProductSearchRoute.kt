package com.jco.kmp.android.features.productsearch.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.jco.kmp.android.features.productsearch.ProductSearchScreen
import com.jco.kmp.features.productsearch.ProductSearchViewModelImpl
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun ProductSearchRoute(
    navController: NavController,
) {
    val viewModel: ProductSearchViewModelImpl = koinViewModel()
    val contactsScreenUiState by viewModel.observeState().collectAsStateWithLifecycle()
    ProductSearchScreen(contactsScreenUiState, navController, viewModel)
}