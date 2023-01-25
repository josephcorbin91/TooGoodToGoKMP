package com.jco.kmp.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

const val PRODUCT_TABLE = "PRODUCT_TABLE"

/**
 * Defines a nutritional product that is saved in the Room Database local storage.
 */
@Entity(
    tableName = PRODUCT_TABLE,
)
actual data class ProductEntityImpl(
    @PrimaryKey(autoGenerate = false)
    override val productId: String,
    override val allergens: String,
    override val brands: String,
    override val code: String,
    override val productName: String,
    override val displayImageUrl : String,
    override  val energy: String,
    override val grade: String
) : ProductEntity