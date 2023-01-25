package com.jco.kmp.core.database.dao

import com.jco.kmp.core.database.entity.ItemRemoteKeyEntityImpl

actual interface RemoteKeysDao {
    actual suspend fun getRemoteKeys(id: String): ItemRemoteKeyEntityImpl?
    actual suspend fun addAllRemoteKeys(remoteKeys: List<ItemRemoteKeyEntityImpl>)
    actual suspend fun deleteAllRemoteKeys()
}