package com.jco.kmp.core.database.dao

import com.jco.kmp.core.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

actual interface ProductDao {
    actual fun getAllProducts(): Flow<List<ProductEntity>>
    actual fun getProduct(productId: String): Flow<ProductEntity?>
    actual suspend fun insertProduct(product: ProductEntity)
    actual suspend fun deleteAllProducts()

}