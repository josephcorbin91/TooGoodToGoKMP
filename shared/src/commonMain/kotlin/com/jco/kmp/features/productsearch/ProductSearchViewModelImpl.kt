package com.jco.kmp.features.productsearch

import com.jco.kmp.core.domain.product.usecase.GetProductUseCase
import com.jco.kmp.core.presentation.BaseViewModel
import com.jco.kmp.features.ProductItemUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

interface ProductSearchViewModel

class ProductSearchViewModelImpl(
    private val getProductUseCase: GetProductUseCase
) : BaseViewModel<ProductSearchViewState, ProductSearchViewAction, ProductSearchViewEffect>(),
    ProductSearchViewModel {
    private val _productSearchViewEffect = MutableSharedFlow<ProductSearchViewEffect>()

    private val _productSearchViewState = MutableStateFlow<ProductSearchViewState>(
        ProductSearchViewState.Content(
            "3017624010701", null
        )
    )

    //3017624010701
    init {
        viewModelScope.launch(Dispatchers.Default) {
            _productSearchViewState.filterIsInstance<ProductSearchViewState.Content>()
                .map { it.searchText }
                .distinctUntilChanged()
                .debounce(DEBOUNCE_TIME)
                .filter { it.length >= MINIMUM_PRODUCT_LENGTH }
                .collectLatest { query ->
                    _productSearchViewState.emit(ProductSearchViewState.Loading)
                    val queriedProduct = getProductUseCase.invoke(query).firstOrNull()
                    if (queriedProduct == null) {
                        _productSearchViewState.emit(ProductSearchViewState.Error)
                        delay(PRODUCT_SEARCH_ERROR_RESET_TIME)
                        _productSearchViewState.emit(ProductSearchViewState.Content("", null))
                    } else {
                        _productSearchViewState.emit(
                            ProductSearchViewState.Content(
                                "",
                                ProductItemUIModel(
                                    queriedProduct.productName,
                                    queriedProduct.productId,
                                    queriedProduct.displayImageUrl
                                )
                            )
                        )
                    }
                }
        }
    }


    private fun searchProduct(search: String) {
        viewModelScope.launch(Dispatchers.Default) {
            _productSearchViewState.update {
                if (it is ProductSearchViewState.Content) it.copy(searchText = search)
                else it
            }
        }
    }

    companion object {
        private const val DEBOUNCE_TIME = 250L
        private const val PRODUCT_SEARCH_ERROR_RESET_TIME = 1500L
        const val MINIMUM_PRODUCT_LENGTH = 13
    }

    override fun observeSideEffects(): Flow<ProductSearchViewEffect> = _productSearchViewEffect

    override fun handleIntent(action: ProductSearchViewAction) {
        when (action) {
            is ProductSearchViewAction.SearchProductAction -> searchProduct(action.id)
        }
    }

    override fun observeState(): StateFlow<ProductSearchViewState> = _productSearchViewState
}