package com.jco.kmp.core.network

import kotlinx.serialization.Serializable

@Serializable
data class NetworkNutriscore(
    val energy: String,
    val grade: String,
)
