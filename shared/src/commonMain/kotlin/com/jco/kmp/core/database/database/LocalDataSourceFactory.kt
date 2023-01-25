package com.jco.kmp.core.database.database

interface LocalDataSourceFactory {
    fun create(): LocalDataSource
}