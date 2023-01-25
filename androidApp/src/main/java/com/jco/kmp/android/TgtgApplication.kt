package com.jco.kmp.android

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import com.jco.kmp.android.di.AppKoinModule
import com.jco.kmp.core.data.product.di.CoreDataProductKoinModule
import com.jco.kmp.core.database.database.CoreDataDatabaseAndroidKoinModule
import com.jco.kmp.core.domain.product.di.CoreDomainProductKoinModule
import com.jco.kmp.core.network.di.CoreNetworkKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * [Application] class for Lydia
 */
class TgtgApplication : Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@TgtgApplication)
            // Load modules

            modules(
                CoreNetworkKoinModule,
                CoreDataProductKoinModule,
                CoreDomainProductKoinModule,
                CoreDataDatabaseAndroidKoinModule,
                AppKoinModule
            )
        }
    }

    override fun newImageLoader(): ImageLoader {

        return ImageLoader.Builder(this)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    }
}
