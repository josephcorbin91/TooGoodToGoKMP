package com.jco.kmp.core.domain.product.usecase

import com.jco.kmp.core.model.ExternalProduct
import kotlinx.coroutines.flow.Flow

/**
 * A use case which obtains a list of searched products from a single source of truth repository.
 */
interface GetAllProductsUseCase {
    /**
     * Returns a list of product items
     */
    operator fun invoke(): Flow<List<ExternalProduct>>
}