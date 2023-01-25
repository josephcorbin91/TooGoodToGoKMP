package com.jco.kmp.android.navigation

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.jco.kmp.android.R
import com.jco.kmp.android.designsystem.icon.Icon
import com.jco.kmp.android.designsystem.icon.TgtgIcons

enum class BottomBarDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int
) {
    SEARCH_PRODUCTS(
        selectedIcon = Icon.ImageVectorIcon(TgtgIcons.Add),
        unselectedIcon = Icon.ImageVectorIcon(TgtgIcons.Add),
        iconTextId = R.string.search_bottom_bar_destination_icon,
        titleTextId = R.string.search_products_bottom_bar_destination_title
    ),
    SAVED_PRODUCTS(
        selectedIcon = Icon.ImageVectorIcon(TgtgIcons.Favorites),
        unselectedIcon = Icon.ImageVectorIcon(TgtgIcons.FavoritesBorder),
        iconTextId = R.string.search_bottom_bar_destination_icon,
        titleTextId = R.string.search_bottom_bar_destination_icon
    )
}

fun NavDestination?.isBottomBarDestinationInHierarchy(destination: BottomBarDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
