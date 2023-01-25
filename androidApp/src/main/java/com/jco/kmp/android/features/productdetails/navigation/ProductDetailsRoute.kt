package com.jco.kmp.android.features.productdetails.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jco.kmp.android.designsystem.component.ErrorScreen
import com.jco.kmp.android.designsystem.component.LoadingScreen
import com.jco.kmp.android.features.productdetails.ui.ProductDetailContent
import com.jco.kmp.android.features.productdetails.ui.ProductDetailsViewModel
import com.jco.kmp.features.productdetails.ProductDetailsViewState
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
internal fun ProductDetailsRoute() {
    val viewModel = koinViewModel<ProductDetailsViewModel>()

    val productDetailUIState by viewModel.observeState().collectAsStateWithLifecycle()
    when (productDetailUIState) {
        ProductDetailsViewState.Error -> ErrorScreen()
        is ProductDetailsViewState.Content -> ProductDetailContent((productDetailUIState as ProductDetailsViewState.Content).productDetailUIModel)
        is ProductDetailsViewState.Loading -> LoadingScreen()
    }
}