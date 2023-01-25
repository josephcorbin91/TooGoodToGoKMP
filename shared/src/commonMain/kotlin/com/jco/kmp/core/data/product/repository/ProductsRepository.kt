package com.jco.kmp.core.data.product.repository

import com.jco.kmp.core.model.ExternalProduct
import kotlinx.coroutines.flow.Flow

/**
 * Data layer implementation for [ExternalProduct]
 */
interface ProductsRepository {
    fun getAllProducts(): Flow<List<ExternalProduct>>
    fun getProduct(productId: String): Flow<ExternalProduct?>
}