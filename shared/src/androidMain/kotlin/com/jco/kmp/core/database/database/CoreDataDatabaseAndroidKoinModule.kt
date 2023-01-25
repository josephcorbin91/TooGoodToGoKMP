package com.jco.kmp.core.database.database

import com.jco.kmp.core.database.ApplicationContext
import com.jco.kmp.core.database.LocalDataSourceFactoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val CoreDataDatabaseAndroidKoinModule = module {
    single<LocalDataSourceFactory> { LocalDataSourceFactoryImpl(androidContext() as ApplicationContext) }
    single<LocalDataSource> { get<LocalDataSourceFactory>().create() }
}