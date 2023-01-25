package com.jco.kmp.core.domain.product.uimodel

import com.jco.kmp.core.model.ExternalProduct

data class ProductDetailUIModel(
    val productId: String,
    val allergens: String,
    val brands: String,
    val code: String,
    val productName: String,
    val displayImageUrl: String,
    val energy: String,
    val grade: String
)

fun ExternalProduct.toProductDetailUIModel() = ProductDetailUIModel(
    productId, allergens, brands, code, productName, displayImageUrl, energy, grade
)