package com.jco.kmp.android.util.network

import kotlinx.coroutines.flow.Flow

/**
 * Is the network online
 */
interface NetworkMonitor {
    val isOnline: Flow<Boolean>
}