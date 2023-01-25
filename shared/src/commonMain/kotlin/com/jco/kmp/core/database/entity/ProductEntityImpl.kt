package com.jco.kmp.core.database.entity

expect class ProductEntityImpl: ProductEntity

interface ProductEntity {
    val productId: String
    val allergens: String
    val brands: String
    val code: String
    val productName: String
    val displayImageUrl : String
    val energy: String
    val grade: String
}