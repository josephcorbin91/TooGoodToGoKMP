package com.jco.kmp.core.model

data class ExternalProduct(
    val productId: String,
    val allergens: String,
    val brands: String,
    val code: String,
    val productName: String,
    val displayImageUrl: String,
    val energy: String,
    val grade: String
)