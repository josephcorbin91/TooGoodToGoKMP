package com.jco.kmp.core.database

import com.jco.kmp.core.database.database.LocalDataSource
import com.jco.kmp.core.database.database.LocalDataSourceFactory

actual class LocalDataSourceFactoryImpl actual constructor(private val context: ApplicationContext) : LocalDataSourceFactory {
    override fun create(): LocalDataSource {
        TODO("Not yet implemented")
    }
}

actual typealias ApplicationContext = Nothing