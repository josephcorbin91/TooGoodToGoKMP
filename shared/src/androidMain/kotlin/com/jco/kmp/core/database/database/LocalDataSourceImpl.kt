package com.jco.kmp.core.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.jco.kmp.core.database.dao.ProductDao
import com.jco.kmp.core.database.entity.ProductEntityImpl

@Database(
    entities = [
        ProductEntityImpl::class
    ],
    version = 1
)
actual abstract class LocalDataSourceImpl(private val context: Context) : RoomDatabase(), LocalDataSource {
    actual abstract override fun productDao(): ProductDao
}