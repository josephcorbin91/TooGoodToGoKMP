package com.jco.kmp.core.data.product.repository

import com.jco.kmp.core.database.entity.ProductEntity
import com.jco.kmp.core.database.entity.ProductEntityImpl
import com.jco.kmp.core.network.NetworkProduct

actual fun NetworkProduct.toDatabaseEntity(): ProductEntityImpl {
    TODO("Not yet implemented")
}