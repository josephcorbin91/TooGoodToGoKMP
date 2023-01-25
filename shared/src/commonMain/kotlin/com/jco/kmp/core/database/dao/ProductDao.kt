package com.jco.kmp.core.database.dao

import com.jco.kmp.core.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow


expect interface ProductDao {
    fun getAllProducts(): Flow<List<ProductEntity>>

    fun getProduct(productId: String): Flow<ProductEntity?>

    suspend fun insertProduct(product: ProductEntity)

    suspend fun deleteAllProducts()
}