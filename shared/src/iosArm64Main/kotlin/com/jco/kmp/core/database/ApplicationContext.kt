package com.jco.kmp.core.database

import com.jco.kmp.core.database.database.LocalDataSource
import com.jco.kmp.core.database.database.LocalDataSourceFactory

actual typealias ApplicationContext = Nothing

actual class LocalDataSourceFactoryImpl actual constructor(context: ApplicationContext) : LocalDataSourceFactory {
    override fun create(): LocalDataSource {
        TODO("Not yet implemented")
    }
}