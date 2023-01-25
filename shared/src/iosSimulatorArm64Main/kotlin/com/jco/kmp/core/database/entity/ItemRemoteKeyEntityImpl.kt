package com.jco.kmp.core.database.entity

actual class ItemRemoteKeyEntityImpl(
    override val id: String,
    override val prevPage: Int?,
    override val nextPage: Int?
) : ItemRemoteKeyEntity