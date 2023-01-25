package com.jco.kmp.core.network.api

import com.jco.kmp.core.network.ProductResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class RemoteDataSourceImpl : RemoteDataSource {
    companion object {
        const val VERSION = "v2"
        const val BASE_URL = "https://world.openfoodfacts.org/api/$VERSION/"
        const val PRODUCT_ENDPOINT = "product/"
    }

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getProduct(productId: String): ProductResponse {
        val response: HttpResponse = client.get(BASE_URL.plus(PRODUCT_ENDPOINT).plus(productId))
        return response.body()
    }

}