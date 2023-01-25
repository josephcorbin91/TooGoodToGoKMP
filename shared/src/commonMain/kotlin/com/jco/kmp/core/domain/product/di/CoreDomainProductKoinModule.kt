package com.jco.kmp.core.domain.product.di

import com.jco.kmp.core.domain.product.usecase.GetAllProductsUseCase
import com.jco.kmp.core.domain.product.usecase.GetAllProductsUseCaseImpl
import com.jco.kmp.core.domain.product.usecase.GetProductUseCase
import com.jco.kmp.core.domain.product.usecase.GetProductUseCaseImpl
import org.koin.dsl.module


val CoreDomainProductKoinModule = module {
    factory<GetAllProductsUseCase> { GetAllProductsUseCaseImpl(get()) }
    factory<GetProductUseCase> { GetProductUseCaseImpl(get()) }
}
