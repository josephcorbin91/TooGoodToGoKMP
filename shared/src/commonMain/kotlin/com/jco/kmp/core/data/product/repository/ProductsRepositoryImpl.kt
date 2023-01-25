package com.jco.kmp.core.data.product.repository

import com.jco.kmp.core.database.database.LocalDataSource
import com.jco.kmp.core.database.entity.ProductEntity
import com.jco.kmp.core.database.entity.ProductEntityImpl
import com.jco.kmp.core.model.ExternalProduct
import com.jco.kmp.core.network.NetworkProduct
import com.jco.kmp.core.network.api.RemoteDataSource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.Mutex

class ProductsRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ProductsRepository {

    // Mutex to make writes to cached values thread-safe.
    private val latestProductsMutex = Mutex()

    // Cache of the latest news got from the network.
    private var inMemoryProductList: MutableStateFlow<List<ExternalProduct>> =
        MutableStateFlow(emptyList())

    // The assumption here is that the network data is not updated all the time and that multiple searches for the same product should not lead to multiple db/nework calls.
    override fun getProduct(productId: String): Flow<ExternalProduct?> = flow {
        // If product being searched is in the in memory cache do not make network call.
        val currentInMemoryProductList = inMemoryProductList.firstOrNull()
        currentInMemoryProductList?.firstOrNull { it.productId == productId }
            ?.let { currentInMemoryProduct ->
                emit(currentInMemoryProduct)
                return@flow
            }

        // Retrieve product from database
        localDataSource.productDao().getProduct(productId).firstOrNull()?.let { persistedProduct ->
            emit(persistedProduct.toExternalModel())
            inMemoryProductList.addExternalProduct(persistedProduct.toExternalModel())
            return@flow
        }

        // Product is neither in database or local cache
        remoteDataSource.getProduct(productId).product?.let { networkProduct ->
            localDataSource.productDao().insertProduct(networkProduct.toDatabaseEntity())
            inMemoryProductList.addExternalProduct(
                networkProduct.toDatabaseEntity().toExternalModel()
            )
            emit(networkProduct.toDatabaseEntity().toExternalModel())
        } ?: emit(null)
    }

    override fun getAllProducts(): Flow<List<ExternalProduct>> =
        localDataSource.productDao().getAllProducts().map { it.map { it.toExternalModel() } }
}

fun MutableStateFlow<List<ExternalProduct>>.addExternalProduct(addedExternalProduct: ExternalProduct) {
    update { inMemoryProductList ->
        val containsProduct =
            inMemoryProductList.any { it.productId == addedExternalProduct.productId }
        val mutableInMemoryProductList = inMemoryProductList.toMutableList()
        if (containsProduct.not()) {
            mutableInMemoryProductList.add(addedExternalProduct)
        }
        mutableInMemoryProductList
    }
}

expect fun NetworkProduct.toDatabaseEntity() : ProductEntityImpl

/**
 * Converts the database model to an external model that can be used at the domain level
 */
fun ProductEntity.toExternalModel() = ExternalProduct(
    productId, allergens, brands, code, productName, displayImageUrl, energy, grade
)