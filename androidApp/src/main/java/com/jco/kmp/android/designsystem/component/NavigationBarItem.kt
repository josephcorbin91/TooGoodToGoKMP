package com.jco.kmp.android.designsystem.component
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RowScope.LydiaNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = LydiaNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = LydiaNavigationDefaults.navigationContentColor(),
            selectedTextColor = LydiaNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = LydiaNavigationDefaults.navigationContentColor(),
            indicatorColor = LydiaNavigationDefaults.navigationIndicatorColor()
        )
    )
}
