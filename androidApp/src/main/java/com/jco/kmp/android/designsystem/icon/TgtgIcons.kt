package com.jco.kmp.android.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

object TgtgIcons {
    val Edit = Icons.Rounded.Edit
    val Phone = Icons.Rounded.Phone
    val Email = Icons.Rounded.Email
    val Add = Icons.Rounded.Add
    val ArrowBack = Icons.Rounded.ArrowBack
    val Favorites = Icons.Rounded.Favorite
    val FavoritesBorder = Icons.Rounded.FavoriteBorder
    val MoreVert = Icons.Default.MoreVert
    val Menu = Icons.Default.Menu
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
