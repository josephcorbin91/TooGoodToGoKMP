package com.jco.kmp.core.database

import com.jco.kmp.core.database.database.LocalDataSourceFactory
import org.koin.dsl.module

expect class ApplicationContext

expect class LocalDataSourceFactoryImpl(context: ApplicationContext) : LocalDataSourceFactory