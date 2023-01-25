package com.jco.kmp.core.network.model

import com.jco.kmp.core.database.entity.ContactEntityImpl

/**
 * Converts the network model to the local model for persisting
 * by the local data source
 */
actual fun NetworkContact.asEntity(): ContactEntityImpl {
    throw Throwable("NOT IMPLEMENTED")
}