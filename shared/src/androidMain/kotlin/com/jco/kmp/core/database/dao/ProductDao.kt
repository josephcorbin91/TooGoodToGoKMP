package com.jco.kmp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jco.kmp.core.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow


@Dao
actual interface ProductDao {
    @Query("SELECT * FROM PRODUCT_TABLE")
    actual fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM PRODUCT_TABLE WHERE productId =:productId")
    actual fun getProduct(productId: String): Flow<ProductEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    actual suspend fun insertProduct(product: ProductEntity)

    @Query("DELETE FROM PRODUCT_TABLE")
    actual suspend fun deleteAllProducts()

}