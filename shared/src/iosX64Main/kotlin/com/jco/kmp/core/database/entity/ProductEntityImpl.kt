package com.jco.kmp.core.database.entity

actual class ProductEntityImpl(
    override val productId: String,
    override val allergens: String,
    override val brands: String,
    override val code: String,
    override val productName: String,
    override val displayImageUrl: String,
    override val energy: String,
    override val grade: String
) : ProductEntity