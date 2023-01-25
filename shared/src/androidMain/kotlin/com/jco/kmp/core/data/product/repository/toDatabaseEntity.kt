package com.jco.kmp.core.data.product.repository

import com.jco.kmp.core.database.entity.ProductEntityImpl
import com.jco.kmp.core.network.NetworkProduct

/**
 * Converts the network model to a database entity.
 */
actual fun NetworkProduct.toDatabaseEntity() = ProductEntityImpl(
    productId = id,
    allergens,
    brands,
    code,
    productName,
    displayImageUrl = displayImage,
    energy = nutriscoreData.energy,
    grade = nutriscoreData.grade
)
