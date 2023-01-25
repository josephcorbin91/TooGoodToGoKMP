package com.jco.kmp.android.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import com.jco.kmp.android.designsystem.component.LydiaNavigationBarItem
import com.jco.kmp.android.designsystem.component.TgtgNavigationBar
import com.jco.kmp.android.designsystem.icon.Icon
import com.jco.kmp.android.navigation.BottomBarDestination
import com.jco.kmp.android.navigation.isBottomBarDestinationInHierarchy

@Composable
fun TgtgBottomBar(
    destinations: List<BottomBarDestination>,
    onNavigateToDestination: (BottomBarDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    TgtgNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            println("Destination $currentDestination")
            val selected = currentDestination.isBottomBarDestinationInHierarchy(destination)
            LydiaNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )

                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}
