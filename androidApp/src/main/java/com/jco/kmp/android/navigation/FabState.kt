package com.jco.tgtg.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.jco.kmp.android.designsystem.icon.TgtgIcons

enum class FabState(
    val icon: ImageVector,
    val color: Color,
    val isVisible: Boolean,
    val actionText: String
) {
    PRODUCTS_TOP_BAR_STATE(
        icon = TgtgIcons.Add,
        color = Color.Red,
        isVisible = true,
        actionText = "Adding functionality currently disabled",
    ),
    PRODUCT_DETAILS_TOP_BAR_STATE(
        icon = TgtgIcons.Add,
        color = Color.Red,
        isVisible = false,
        actionText = "Editing functionality currently disabled",

    ),
    PRODUCT_SEARCH_TOP_BAR_STATE(
        icon = TgtgIcons.Edit,
        color = Color.Blue,
        isVisible = false,
        actionText = "",
    )
}