package com.jco.kmp.core.database.entity

actual class ContactEntityImpl(
    override val email: String,
    override val gender: String,
    override val name: NameEntity,
    override val phone: String,
    override val cell: String,
    override val picture: PictureEntity,
    override val nat: String
) : ContactEntity