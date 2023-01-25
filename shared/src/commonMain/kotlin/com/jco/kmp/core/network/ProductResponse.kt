package com.jco.kmp.core.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("product") var product: NetworkProduct? = null,
    @SerialName("status")
    var statusCode: Int,
    @SerialName("status_verbose") var status: String,
)