package com.jco.kmp.core.domain.product.usecase

import com.jco.kmp.core.model.ExternalProduct
import com.jco.kmp.core.data.product.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

/**
 * A use case which obtains a list of products from a single source of truth repository.
 */
class GetAllProductsUseCaseImpl(
    private val productsRepository: ProductsRepository
) : GetAllProductsUseCase {
    /**
     * Returns a list of saved products
     */
    override operator fun invoke(): Flow<List<ExternalProduct>> =
        productsRepository.getAllProducts()

}