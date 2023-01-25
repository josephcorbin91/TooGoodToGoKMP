package com.jco.kmp.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkProduct(
    @SerialName("_id") val id: String,
    val allergens: String,
    val brands: String,
    val code: String,
    @SerialName("nutriscore_data") val nutriscoreData: NetworkNutriscore,
    @SerialName("product_name") val productName: String,
    @SerialName("image_front_url") val displayImage: String,
)
