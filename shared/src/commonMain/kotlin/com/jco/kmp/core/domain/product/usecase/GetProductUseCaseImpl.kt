package com.jco.kmp.core.domain.product.usecase

import com.jco.kmp.core.data.product.repository.ProductsRepository
import com.jco.kmp.core.model.ExternalProduct
import kotlinx.coroutines.flow.Flow

/**
 * A use case which obtains a product given an id from a single source of truth repository.
 */
class GetProductUseCaseImpl(
    private val productsRepository: ProductsRepository
) : GetProductUseCase {
    /**
     * Returns a single product
     */
    override operator fun invoke(productId: String): Flow<ExternalProduct?> =
        productsRepository.getProduct(productId = productId)
}