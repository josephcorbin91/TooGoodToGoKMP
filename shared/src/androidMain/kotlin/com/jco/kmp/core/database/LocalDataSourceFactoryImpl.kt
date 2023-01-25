package com.jco.kmp.core.database

import android.app.Application
import androidx.room.Room
import com.jco.kmp.core.database.database.LocalDataSource
import com.jco.kmp.core.database.database.LocalDataSourceFactory
import com.jco.kmp.core.database.database.LocalDataSourceImpl
import org.koin.dsl.module


actual typealias ApplicationContext = Application

actual class LocalDataSourceFactoryImpl actual constructor(private val context: ApplicationContext) :
    LocalDataSourceFactory {
    override fun create() = Room.databaseBuilder(
        context,
        LocalDataSourceImpl::class.java,
        DB_NAME
    ).build()

    companion object {
        private const val DB_NAME = "kmp.db"
    }

}


val CoreDataDatabaseKoinModule = module {
    single<LocalDataSource> { get<LocalDataSourceFactory>().create() }
}