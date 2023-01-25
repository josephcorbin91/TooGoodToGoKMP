package com.jco.kmp.android.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.jco.kmp.android.R
import com.jco.kmp.android.designsystem.icon.TgtgIcons

enum class CurrentDestinationState(
    val navigationIcon: ImageVector,
    val titleTextId: Int,
    val actionIcon: ImageVector,
    val actionIconContentDescription: Int
) {
    PRODUCTS_TOP_BAR_STATE(
        navigationIcon = TgtgIcons.Menu,
        titleTextId = R.string.products_top_bar_title,
        actionIcon = TgtgIcons.MoreVert,
        actionIconContentDescription = R.string.products_top_bar_content_description,
    ),
    PRODUCTS_SEARCH_TOP_BAR_STATE(
        navigationIcon =
        TgtgIcons.Menu,
        titleTextId = R.string.product_search_top_bar_title,
        actionIcon = TgtgIcons.MoreVert,
        actionIconContentDescription = R.string.product_search_top_bar_content_description,
    ),
    PRODUCT_DETAILS_TOP_BAR_STATE(
        navigationIcon =
        TgtgIcons.ArrowBack,
        titleTextId = R.string.product_details_top_bar_title,
        actionIcon = TgtgIcons.MoreVert,
        actionIconContentDescription = R.string.product_details_top_bar_content_description,
    )
}