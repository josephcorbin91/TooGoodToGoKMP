package com.jco.kmp.android.di

import com.jco.kmp.android.MainActivityViewModel
import com.jco.kmp.android.features.productdetails.ui.ProductDetailsViewModel
import com.jco.kmp.android.util.network.NetworkMonitor
import com.jco.kmp.android.util.network.NetworkMonitorImpl
import com.jco.kmp.features.products.ProductsViewModel
import com.jco.kmp.features.productsearch.ProductSearchViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val AppKoinModule = module {
    viewModel { MainActivityViewModel(get()) }
    viewModel { ProductsViewModel(get()) }
    viewModelOf(::ProductSearchViewModelImpl)
    viewModel { ProductDetailsViewModel(get(), get()) }
    single<NetworkMonitor> { NetworkMonitorImpl(get()) }
}
