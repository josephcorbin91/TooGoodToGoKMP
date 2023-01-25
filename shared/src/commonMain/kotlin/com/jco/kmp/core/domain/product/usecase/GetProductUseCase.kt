package com.jco.kmp.core.domain.product.usecase

import com.jco.kmp.core.model.ExternalProduct
import kotlinx.coroutines.flow.Flow

/**
 * A use case which obtains a product based on a productId from a single source of truth repository.
 */
interface GetProductUseCase {
    /**
     * Returns a single contact
     */
    operator fun invoke(productId: String): Flow<ExternalProduct?>
}