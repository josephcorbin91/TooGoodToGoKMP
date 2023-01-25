package com.jco.kmp.features.products

import com.jco.kmp.core.domain.product.usecase.GetAllProductsUseCase
import com.jco.kmp.core.presentation.BaseViewModel
import com.jco.kmp.features.ProductItemUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : BaseViewModel<ProductsViewState, ProductsViewAction, ProductViewEffect>() {

    private val _productViewEffect = MutableSharedFlow<ProductViewEffect>()

    private val _productsViewState =
        MutableStateFlow<ProductsViewState>(ProductsViewState.Content(emptyList()))

    init {
        viewModelScope.launch {
            getAllProductsUseCase.invoke()
                .onStart { _productsViewState.emit(ProductsViewState.Loading) }
                .catch { _productsViewState.emit(ProductsViewState.Error) }
                .onEach { externalProductList ->
                    _productsViewState.emit(
                        if (externalProductList.isEmpty()) {
                            ProductsViewState.Empty
                        } else {
                            ProductsViewState.Content(externalProductList.map { externalProduct ->
                                ProductItemUIModel(
                                    name = externalProduct.productName,
                                    id = externalProduct.productId,
                                    displayImageUrl = externalProduct.displayImageUrl
                                )
                            })
                        }
                    )
                }.flowOn(Dispatchers.Default).collect()

        }
    }

    override fun observeSideEffects(): Flow<ProductViewEffect> = _productViewEffect

    override fun handleIntent(action: ProductsViewAction) {}

    override fun observeState(): StateFlow<ProductsViewState> = _productsViewState
}