package com.jco.kmp.core.network.api

import com.jco.kmp.core.network.ProductResponse

interface RemoteDataSource {
    suspend fun getProduct(productId: String,
    ): ProductResponse
}