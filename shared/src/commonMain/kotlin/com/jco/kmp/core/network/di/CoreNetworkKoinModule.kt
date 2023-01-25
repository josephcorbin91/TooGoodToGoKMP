package com.jco.kmp.core.network.di

import com.jco.kmp.core.network.api.RemoteDataSource
import com.jco.kmp.core.network.api.RemoteDataSourceImpl
import org.koin.dsl.module


val CoreNetworkKoinModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl() }
}