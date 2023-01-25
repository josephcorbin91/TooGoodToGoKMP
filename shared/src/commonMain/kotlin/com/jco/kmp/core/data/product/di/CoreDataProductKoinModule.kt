package com.jco.kmp.core.data.product.di

import com.jco.kmp.core.data.product.repository.ProductsRepository
import com.jco.kmp.core.data.product.repository.ProductsRepositoryImpl
import org.koin.dsl.module


val CoreDataProductKoinModule = module {
    factory<ProductsRepository> { ProductsRepositoryImpl(get(), get()) }
}