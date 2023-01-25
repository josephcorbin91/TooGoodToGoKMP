package com.jco.kmp.android.features.products.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.jco.kmp.android.features.products.ProductsScreen
import com.jco.kmp.features.products.ProductsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun ProductsRoute(
    navController: NavController,
) {
    val viewModel = koinViewModel<ProductsViewModel>()
    val contactsScreenUiState by viewModel.observeState().collectAsStateWithLifecycle()
    ProductsScreen(contactsScreenUiState, navController)
}