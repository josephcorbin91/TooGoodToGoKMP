package com.jco.kmp.features.productdetails

import com.jco.kmp.core.domain.product.uimodel.toProductDetailUIModel
import com.jco.kmp.core.presentation.BaseViewModel
import com.jco.kmp.core.domain.product.usecase.GetProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
//
//class ProductDetailsViewModel(
//    getProductUseCase: GetProductUseCase,
//    private val state: SavedStateHandle,
//) : BaseViewModel<ProductDetailsViewState, ProductDetailsViewAction, ProductDetailsViewEffect>() {
//
//    private val productId = state.get<String>(PRODUCT_ID)!!
//    private val _productDetailUiState: StateFlow<ProductDetailsViewState> =
//        getProductUseCase(productId)
//            .onStart { delay(500L) } //artificial delay to show loading
//            .map { externalModel ->
//                if (externalModel != null) {
//                    ProductDetailsViewState.Content(externalModel.toProductDetailUIModel())
//                } else {
//                    ProductDetailsViewState.Error
//                }
//            }
//            .flowOn(Dispatchers.Default)
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000),
//                initialValue = ProductDetailsViewState.Loading
//            )
//
//    override fun observeSideEffects(): Flow<ProductDetailsViewEffect> {
//        TODO("Not yet implemented")
//    }
//
//    override fun observeState(): StateFlow<ProductDetailsViewState> = _productDetailUiState
//    override fun handleIntent(action: ProductDetailsViewAction) {
//        TODO("Not yet implemented")
//    }
//}
