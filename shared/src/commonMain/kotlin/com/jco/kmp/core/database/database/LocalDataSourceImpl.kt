package com.jco.kmp.core.database.database

import com.jco.kmp.core.database.dao.ProductDao

interface LocalDataSource {
    fun productDao(): ProductDao
}

expect abstract class LocalDataSourceImpl : LocalDataSource {
    abstract override fun productDao(): ProductDao
}