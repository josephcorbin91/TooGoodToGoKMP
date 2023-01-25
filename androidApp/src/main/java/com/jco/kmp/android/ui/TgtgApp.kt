package com.jco.kmp.android.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.SnackbarDuration.Indefinite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jco.kmp.android.R
import com.jco.kmp.android.designsystem.component.TgtgBackground
import com.jco.kmp.android.designsystem.component.TgtgTopAppBar
import com.jco.tgtg.core.designsystem.showToast
import com.jco.kmp.android.navigation.CurrentDestinationState
import com.jco.tgtg.navigation.TgtgNavHost
import com.jco.kmp.android.ui.components.TgtgBottomBar

@OptIn(
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class,
)
@Composable
fun TgtgApp(
    appState: TgtgAppState,
) {
    TgtgBackground {

        val snackbarHostState = remember { SnackbarHostState() }

        val isOffline by appState.isOffline.collectAsStateWithLifecycle()

        // If user is not connected to the internet show a snack bar to inform them.
        val notConnectedMessage = stringResource(id = R.string.app_not_connected)
        LaunchedEffect(isOffline) {
            if (isOffline) snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = Indefinite
            )
        }

        val uiState by appState.mainActivityUiState.collectAsStateWithLifecycle()
        Scaffold(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                val currentTopBarState = appState.currentDestinationState
                val context = LocalContext.current
                TgtgTopAppBar(
                    navigationIcon = currentTopBarState.navigationIcon,
                    titleRes = currentTopBarState.titleTextId,
                    actionIcon = currentTopBarState.actionIcon,
                    actionIconContentDescription = stringResource(id = currentTopBarState.actionIconContentDescription),
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Blue
                    ),
                    onActionClick = {
                        context.showToast("Settings functionality currently disabled")
                    },
                    onNavigationClick = {
                        when (currentTopBarState) {
                            CurrentDestinationState.PRODUCT_DETAILS_TOP_BAR_STATE -> appState.onBackClick()
                            CurrentDestinationState.PRODUCTS_TOP_BAR_STATE,
                            CurrentDestinationState.PRODUCTS_SEARCH_TOP_BAR_STATE -> context.showToast(
                                "Menu functionality currently disabled"
                            )
                        }
                    },
                    navigationIconContentDescription = "Menu icon"
                )
            },
            floatingActionButton = {
                val context = LocalContext.current
                val currentFabState = appState.currentFabState
                if (currentFabState != null) {
                    if (currentFabState.isVisible) {
                        FloatingActionButton(
                            shape = CircleShape,
                            onClick = {
                                context.showToast(currentFabState.actionText)
                            },
                            containerColor = currentFabState.color,
                            contentColor = Color.White
                        ) {
                            Icon(currentFabState.icon, "")
                        }
                    }
                }
            },
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    TgtgBottomBar(
                        destinations = appState.bottomBarDestinations,
                        onNavigateToDestination = appState::navigateToBottomBarDestination,
                        currentDestination = appState.currentDestination,
                        modifier = Modifier.testTag("LydiaBottomBar")
                    )
                }
            }
        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumedWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                ) {
                    TgtgNavHost(
                        navController = appState.navController,
                    )
                }
            }
        }
    }
}